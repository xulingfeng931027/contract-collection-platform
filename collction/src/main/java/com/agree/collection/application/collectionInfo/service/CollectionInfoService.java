package com.agree.collection.application.collectionInfo.service;

import cn.hutool.core.collection.CollectionUtil;
import com.agree.collection.application.collectionInfo.assembler.CollectionInfoAssembler;
import com.agree.collection.application.collectionInfo.dto.CollectionInfoDto;
import com.agree.collection.application.collectionInfo.dto.ExecuteCollectionReqDto;
import com.agree.collection.application.collectionInfo.support.AccountInfoSupport;
import com.agree.collection.application.collectionInfo.support.ContractSupport;
import com.agree.collection.application.collectionrecord.service.CollectionRecordService;
import com.agree.collection.application.support.SMSNotifySupport;
import com.agree.collection.domain.collectionInfo.entity.CollectionInfo;
import com.agree.collection.domain.collectionRecord.entity.CollectionRecord;
import com.agree.collection.domain.collectionRecord.factory.CollectionRecordFactory;
import com.agree.collection.domain.collectionRecord.service.ContractAndAccountInfoDomainService;
import com.agree.collection.domain.valueobject.CollctionResultEnum;
import com.agree.collection.domain.valueobject.CommercialTenantContract;
import com.agree.collection.infrastructure.mq.KafkaProducer;
import com.agree.common.exception.ApplicationException;
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
    private static List<ExecuteCollectionReqDto> assemblyCollectionParamsReq(List<CollectionInfo> collectionInfoList, String receiveAccountId) {
        return collectionInfoList.stream().map(e -> ExecuteCollectionReqDto.builder().payAccountInfoId(e.getCustomerAccountInfo().getId()).receiveAccountInfoId(receiveAccountId).amount(e.getAmount()).build()).collect(Collectors.toList());
    }

    /**
     * 代收
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public CollectionInfoDto singleCollection(CollectionInfoDto collectionInfoDto) {
        CollectionInfo collectionInfo = collectionInfoAssembler.toEntity(collectionInfoDto);
        String contractId = collectionInfoDto.getContractId();
        //查询商户合约
        CommercialTenantContract commercialTenantContract = contractSupport.queryCommercialTenantContract(contractId);
        if (commercialTenantContract == null) {
            throw new ApplicationException("商户合约不存在");
        }
        //校验商户合约
        commercialTenantContract.checkStatus();
        //校验商户账户信息
        accountInfoSupport.checkAccountInfo(commercialTenantContract.getAccountInfoId(), ACCOUNT_RULE_CODE);
        if (StringUtils.isNoneBlank(commercialTenantContract.getTempAccountInfoId())) {
            accountInfoSupport.checkAccountInfo(commercialTenantContract.getTempAccountInfoId(), ACCOUNT_RULE_CODE);
        }
        //todo 此处使用了领域服务  查询并校验客户合约
        contractAndAccountInfoDomainService.checkCustomerContractAndCustomerAccountInfo(Lists.newArrayList(collectionInfo));
        String receiveAccountId;
        if (StringUtils.isNoneBlank(commercialTenantContract.getTempAccountInfoId())) {
            receiveAccountId = commercialTenantContract.getTempAccountInfoId();
        } else {
            receiveAccountId = commercialTenantContract.getAccountInfoId();
        }
        //调用核心系统执行代收
        Map<String, Object> collectionResult = accountInfoSupport.executeCollection(ExecuteCollectionReqDto.builder().payAccountInfoId(collectionInfo.getCustomerAccountInfo().getId()).receiveAccountInfoId(receiveAccountId).amount(collectionInfoDto.getAmount()).build());
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
        String contractId = getContractId(collectionInfoDtoList);
        //查询商户合约
        CommercialTenantContract commercialTenantContract = contractSupport.queryCommercialTenantContract(contractId);
        if (commercialTenantContract == null) {
            throw new ApplicationException("商户合约不存在");
        }
        //校验商户合约
        commercialTenantContract.checkStatus();
        //校验商户账户信息
        accountInfoSupport.checkAccountInfo(commercialTenantContract.getAccountInfoId(), ACCOUNT_RULE_CODE);
        if (StringUtils.isNoneBlank(commercialTenantContract.getTempAccountInfoId())) {
            accountInfoSupport.checkAccountInfo(commercialTenantContract.getTempAccountInfoId(), ACCOUNT_RULE_CODE);
        }
        //todo 此处使用了领域服务  查询并校验客户合约
        contractAndAccountInfoDomainService.checkCustomerContractAndCustomerAccountInfo(collectionInfoList);
        String receiveAccountId;
        if (StringUtils.isNoneBlank(commercialTenantContract.getTempAccountInfoId())) {
            receiveAccountId = commercialTenantContract.getTempAccountInfoId();
        } else {
            receiveAccountId = commercialTenantContract.getAccountInfoId();
        }
        List<ExecuteCollectionReqDto> executeCollectionReqDtos = assemblyCollectionParamsReq(collectionInfoList, receiveAccountId);
        //调用核心接口代收
        accountInfoSupport.executeCollection(executeCollectionReqDtos);
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
    private String getContractId(List<CollectionInfoDto> collectionInfoDtoList) {
        return collectionInfoDtoList.get(0).getContractId();
    }
}
