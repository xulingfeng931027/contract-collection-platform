package com.agree.collectionpay.application.collection.service;

import cn.hutool.core.collection.CollectionUtil;
import com.agree.collectionpay.application.collection.collectionInfo.dto.CollectionInfoDto;
import com.agree.collectionpay.application.collectionInfo.assembler.CollectionInfoAssembler;
import com.agree.collectionpay.application.support.EventPublishSupport;
import com.agree.collectionpay.application.support.SMSNotifySupport;
import com.agree.collectionpay.domain.collection.collectionInfo.entity.CollectionInfo;
import com.agree.collectionpay.domain.collection.collectionRecord.entity.CollectionEvent;
import com.agree.collectionpay.domain.collection.collectionRecord.entity.CollectionRecord;
import com.agree.collectionpay.domain.collection.collectionRecord.factory.CollectionRecordFactory;
import com.agree.collectionpay.domain.collection.collectionRecord.repository.CollectionRecordRepository;
import com.agree.collectionpay.domain.collection.exception.CollectionException;
import com.agree.collectionpay.domain.collection.service.ContractAndAccountInfoDomainService;
import com.agree.collectionpay.domain.collection.support.AccountInfoSupport;
import com.agree.collectionpay.domain.collection.support.ContractSupport;
import com.agree.collectionpay.domain.collection.valueobject.CollectionResult;
import com.agree.collectionpay.domain.collection.valueobject.CommercialTenantContract;
import com.agree.collectionpay.domain.collection.valueobject.CustomerContract;
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
 * 
 */
@Service
public class CollectionInfoService {

    private static final String COLLECTION_TOPIC = "COLLECTION_TOPIC";
    @Autowired
    private AccountInfoSupport accountInfoSupport;
    @Autowired
    private ContractSupport contractSupport;
    @Autowired
    private CollectionRecordRepository collectionRecordRepository;
    @Autowired
    private CollectionInfoAssembler collectionInfoAssembler;
    @Autowired
    private ContractAndAccountInfoDomainService contractAndAccountInfoDomainService;
    @Autowired
    private EventPublishSupport eventPublishSupport;
    @Autowired
    private SMSNotifySupport smsNotifySupport;


    /**
     * 单笔代收
     *
     * @return
     */
    @Transactional(rollbackFor = CollectionException.class)
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
        //完善合约信息
        collectionInfo.completeCommercialTenantContract(commercialTenantContract);
        //校验结算账户信息
        accountInfoSupport.checkAccountInfo(commercialTenantContract.getSettlementAccountInfo().getId());
        //如果是汇总模式，则校验暂存账户信息
        if (commercialTenantContract.fundGatherModeIsSum()) {
            //校验暂存账户信息
            accountInfoSupport.checkAccountInfo(commercialTenantContract.getStagingAccountInfo().getId());
        }
        //todo 此处使用了领域服务  查询并校验客户合约
        CustomerContract customerContract = contractAndAccountInfoDomainService.querySingleAndCheckCustomerContractAndCustomerAccountInfo(collectionInfo);
        //补全合约
        collectionInfo.completeCustomerContract(customerContract);
        //调用核心系统执行代收
        CollectionResult collectionResult = accountInfoSupport.executeCollection(collectionInfo);
        //生成并保存代收记录
        CollectionRecord collectionRecord = CollectionRecordFactory.generateCollectionRecordForSingle(collectionInfo, collectionResult);
        //发送消息通知
        notifyCommercialTenantAndCustomer(collectionRecord, collectionResult);
        collectionRecordRepository.saveRecord(collectionRecord);
        return collectionInfoDto;
    }


    private void notifyCommercialTenantAndCustomer(CollectionRecord collectionRecord, CollectionResult collectionResult) {
        //如果缴费成功，则通知商户
        if (collectionResult.isSuccess()) {
            eventPublishSupport.publish(CollectionEvent.create(COLLECTION_TOPIC, collectionRecord, collectionRecord.getStatus()));
        }
        //无论成功/失败，都需要通知客户
        smsNotifySupport.sendSMS(new HashMap<>());
    }

    /**
     * 批量代收
     *
     * @return 执行结果
     */
    @Transactional(rollbackFor = CollectionException.class)
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
        //校验结算账户信息
        accountInfoSupport.checkAccountInfo(commercialTenantContract.getSettlementAccountInfo().getId());
        //如果是汇总模式，则校验暂存账户信息
        if (commercialTenantContract.fundGatherModeIsSum()) {
            //校验暂存账户信息信息
            accountInfoSupport.checkAccountInfo(commercialTenantContract.getStagingAccountInfo().getId());
        }
        //调用领域服务 查询并校验客户合约
        List<CustomerContract> customerContractList = contractAndAccountInfoDomainService.queryBatchAndCheckCustomerContractAndCustomerAccountInfo(collectionInfoList);
        //完善客户合约信息
        completeCustomerContract(collectionInfoList, customerContractList);
        //调用核心接口代收(异步)
        accountInfoSupport.executeCollection(collectionInfoList);
        //批量生成保存代收记录
        List<CollectionRecord> collectionRecords = CollectionRecordFactory.generateCollectionRecordForBatch(collectionInfoList);
        collectionRecordRepository.saveRecordBatch(collectionRecords);
    }

    /**
     * 获取商户合约id
     *
     * @return
     */
    private String getCommercialTenantContractId(List<CollectionInfoDto> collectionInfoDtoList) {
        return collectionInfoDtoList.get(0).getCommercialTenantContractId();
    }

    /**
     * 完善代收信息中的客户合约属性
     *
     * @param collectionInfoList   代收信息列表
     * @param customerContractList 客户合约列表
     */
    private List<CollectionInfo> completeCustomerContract(List<CollectionInfo> collectionInfoList, List<CustomerContract> customerContractList) {
        Map<String, CustomerContract> map = customerContractList.stream().collect(Collectors.toMap(CustomerContract::getId, e -> e));
        collectionInfoList.forEach(e -> e.completeCustomerContract(map.get(e.getCustomerContract().getId())));
        return collectionInfoList;
    }
}
