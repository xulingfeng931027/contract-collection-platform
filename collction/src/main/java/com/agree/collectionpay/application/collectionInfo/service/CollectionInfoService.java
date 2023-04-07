package com.agree.collectionpay.application.collectionInfo.service;

import cn.hutool.core.collection.CollectionUtil;
import com.agree.collectionpay.application.collectionInfo.assembler.CollectionInfoAssembler;
import com.agree.collectionpay.application.collectionInfo.dto.CollectionInfoDto;
import com.agree.collectionpay.application.collectionrecord.service.CollectionRecordService;
import com.agree.collectionpay.application.payableInfo.dto.ExecutePayReqDto;
import com.agree.collectionpay.application.support.AccountInfoSupport;
import com.agree.collectionpay.application.support.ContractSupport;
import com.agree.collectionpay.application.support.SMSNotifySupport;
import com.agree.collectionpay.domain.collectionInfo.entity.CollectionInfo;
import com.agree.collectionpay.domain.collectionRecord.entity.CollectionRecord;
import com.agree.collectionpay.domain.collectionRecord.factory.CollectionRecordFactory;
import com.agree.collectionpay.domain.collectionRecord.service.ContractAndAccountInfoDomainService;
import com.agree.collectionpay.domain.exception.CollectionException;
import com.agree.collectionpay.domain.valueobject.CollctionResultEnum;
import com.agree.collectionpay.domain.valueobject.CommercialTenantContract;
import com.agree.collectionpay.infrastructure.mq.KafkaProducer;
import com.alibaba.fastjson2.JSON;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xulingfeng
 * @description 代收信息服务
 * @date 2023/2
 */
@Service
public class CollectionInfoService {


    private static final String ACCOUNT_RULE_CODE = "XXX";
    @Autowired
    private AccountInfoSupport accountInfoSupport;
    @Autowired
    private ContractSupport contractSupport;
    private static final String COMMERCIAL_TENANT_TOPIC = "COMMERCIAL_TENANT_TOPIC";
    @Autowired
    private CollectionRecordService collectionRecordService;
    @Autowired
    private CollectionInfoAssembler collectionInfoAssembler;
    @Autowired
    private ContractAndAccountInfoDomainService contractAndAccountInfoDomainService;
    @Autowired
    private KafkaProducer kafkaProducer;
    @Autowired
    private SMSNotifySupport smsNotifySupport;

    /**
     * 组装代收参数
     *
     * @param collectionInfoList 代收信息
     * @param receiveAccountId   收款账户id
     * @return
     */
    private static List<ExecutePayReqDto> assemblyCollectionParamsReq(List<CollectionInfo> collectionInfoList, String receiveAccountId) {
        return collectionInfoList.stream().map(e -> ExecutePayReqDto.builder().payAccountInfoId(e.getCustomerContract().getCustomerAccountInfo().getId()).receiveAccountInfoId(receiveAccountId).amount(e.getAmount()).build()).collect(Collectors.toList());
    }

    /**
     * 代收
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public CollectionInfoDto singleCollection(CollectionInfoDto collectionInfoDto) {
        CollectionInfo collectionInfo = collectionInfoAssembler.toEntity(collectionInfoDto);
        String commercialTenantContractId = collectionInfo.getCommercialTenantContract().getId();
        //查询商户合约
        CommercialTenantContract commercialTenantContract = contractSupport.queryCommercialTenantContract(commercialTenantContractId);
        if (commercialTenantContract == null) {
            throw new CollectionException("商户合约不存在");
        }
        //校验商户合约
        commercialTenantContract.checkStatusIfNormal();
        collectionInfo.completeCommercialTenantContract(commercialTenantContract);
        //校验商户账户信息
        String settlementAccountId = commercialTenantContract.getSettlementAccountInfo().getId();
        accountInfoSupport.checkAccountInfo(settlementAccountId, ACCOUNT_RULE_CODE);
        String stagingAccountInfoId = commercialTenantContract.getStagingAccountInfo().getId();
        if (StringUtils.isNoneBlank(stagingAccountInfoId)) {
            accountInfoSupport.checkAccountInfo(commercialTenantContract.getStagingAccountInfo().getId(), ACCOUNT_RULE_CODE);
        }
        //todo 此处使用了领域服务  查询并校验客户合约
        contractAndAccountInfoDomainService.checkCustomerContractAndCustomerAccountInfo(Lists.newArrayList(collectionInfo));
        String receiveAccountId;
        if (StringUtils.isNoneBlank(stagingAccountInfoId)) {
            receiveAccountId = stagingAccountInfoId;
        } else {
            receiveAccountId = settlementAccountId;
        }
        //调用核心系统执行代收
        Map<String, Object> collectionResult = accountInfoSupport.executeCollection(assemblyCollectionParamsReq(Lists.newArrayList(collectionInfo), receiveAccountId).get(0));

        //生成并保存代收记录
        CollectionRecord collectionRecord = CollectionRecordFactory.generateCollectionRecordForBatch(collectionInfo, receiveAccountId, collectionResult);
        //发送消息通知
        notifyCommercialTenantAndCustomer(collectionRecord, collectionResult);
        collectionRecordService.save(collectionRecord);
        return collectionInfoDto;
    }

    private void notifyCommercialTenantAndCustomer(CollectionRecord collectionRecord, Map<String, Object> collectionResult) {
        //如果缴费成功，则通知商户
        if (collectionResult.get("result") == CollctionResultEnum.SUCCESS) {
            kafkaProducer.sendMessage(COMMERCIAL_TENANT_TOPIC, JSON.toJSONString(collectionRecord));
        }
        //无论成功/失败，都需要通知客户
        smsNotifySupport.sendSMS(new HashMap<>());
    }

    /**
     * 批量代收
     *
     * @return 执行结果
     */
    @Transactional(rollbackFor = Exception.class)
    public void batchCollection(List<CollectionInfoDto> collectionInfoDtoList) {
        if (CollectionUtil.isEmpty(collectionInfoDtoList)) {
            return;
        }
        List<CollectionInfo> collectionInfoList = collectionInfoAssembler.toEntity(collectionInfoDtoList);
        //获取商户合约id
        String contractId = getCommercialTenantContractId(collectionInfoDtoList);
        //查询商户合约
        CommercialTenantContract commercialTenantContract = contractSupport.queryCommercialTenantContract(contractId);
        if (commercialTenantContract == null) {
            throw new CollectionException("商户合约不存在");
        }
        //校验商户合约
        commercialTenantContract.checkStatusIfNormal();
        collectionInfoList.forEach(e -> e.completeCommercialTenantContract(commercialTenantContract));
        //校验商户账户信息
        String settlementAccountId = commercialTenantContract.getSettlementAccountInfo().getId();
        accountInfoSupport.checkAccountInfo(settlementAccountId, ACCOUNT_RULE_CODE);
        String stagingAccountInfoId = commercialTenantContract.getStagingAccountInfo().getId();
        if (StringUtils.isNoneBlank(stagingAccountInfoId)) {
            accountInfoSupport.checkAccountInfo(commercialTenantContract.getStagingAccountInfo().getId(), ACCOUNT_RULE_CODE);
        }
        //todo 此处使用了领域服务  查询并校验客户合约
        contractAndAccountInfoDomainService.checkCustomerContractAndCustomerAccountInfo(collectionInfoList);
        String receiveAccountId;
        if (StringUtils.isNoneBlank(stagingAccountInfoId)) {
            receiveAccountId = stagingAccountInfoId;
        } else {
            receiveAccountId = settlementAccountId;
        }
        List<ExecutePayReqDto> ExecutePayReqDtos = assemblyCollectionParamsReq(collectionInfoList, receiveAccountId);
        //调用核心接口代收
        accountInfoSupport.executeCollection(ExecutePayReqDtos);
        collectionInfoList.forEach(e -> {
            CollectionRecord collectionRecord = CollectionRecordFactory.generateCollectionRecordForBatch(e, receiveAccountId);
            //todo 优化为批量插入
            collectionRecordService.save(collectionRecord);
        });
    }

    /**
     * 获取商户合约id
     *
     * @return
     */
    private String getCommercialTenantContractId(List<CollectionInfoDto> collectionInfoDtoList) {
        return collectionInfoDtoList.get(0).getCommercialTenantContractId();
    }
}
