package com.zantong.collection.application.collectionInfo.service;

import cn.hutool.core.collection.CollectionUtil;
import com.zantong.collection.application.collectionInfo.assembler.CollectionInfoAssembler;
import com.zantong.collection.application.collectionInfo.dto.CollectionInfoDto;
import com.zantong.collection.application.collectionInfo.dto.ExecuteCollectionReqDto;
import com.zantong.collection.application.collectionInfo.support.AccountInfoSupport;
import com.zantong.collection.application.collectionInfo.support.ContractSupport;
import com.zantong.collection.domain.collectionInfo.entity.CollectionInfo;
import com.zantong.collection.domain.collectionRecord.entity.CollectionRecord;
import com.zantong.collection.domain.collectionRecord.repository.CollectionRepository;
import com.zantong.collection.domain.collectionRecord.service.CollectionDomainService;
import com.zantong.collection.domain.valueobject.BusinessContract;
import com.zantong.collection.domain.valueobject.CustomerContract;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xulingfeng
 * @description 签约服务
 * @date 2023/2
 */
@Service
public class CollectionService {


    private static final String ACCOUNT_RULE_CODE = "XXX";
    @Autowired
    private AccountInfoSupport accountInfoSupport;
    @Autowired
    private ContractSupport contractSupport;
    @Autowired
    private CollectionRepository collectionRecordRepository;
    @Autowired
    private CollectionDomainService collectionDomainService;
    @Autowired
    private CollectionInfoAssembler collectionInfoAssembler;

    /**
     * 代收
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public CollectionInfoDto singleCollection(CollectionInfoDto collectionInfoDto) {
        CollectionInfo collectionInfo = collectionInfoAssembler.toEntity(collectionInfoDto);
        String projectCode = collectionInfoDto.getProjectCode();
        BusinessContract businessContract = contractSupport.queryBusinessContract(projectCode);
        if (businessContract == null) {

        }
        businessContract.checkStatus();
        //校验商户账户信息
        accountInfoSupport.checkAccountInfo(businessContract.getAccountInfoId(), ACCOUNT_RULE_CODE);
        accountInfoSupport.checkAccountInfo(businessContract.getTempAccountInfoId(), ACCOUNT_RULE_CODE);
        //查询并校验客户合约
        List<CustomerContract> customerContracts = collectionDomainService.handleCustomer(collectionInfoDtoList);
        if (CollectionUtil.isEmpty(customerContracts)) {
            return null;
        }
        String receiveAccountId;
        if (StringUtils.isNoneBlank(businessContract.getTempAccountInfoId())) {
            receiveAccountId = businessContract.getTempAccountInfoId();
        } else {
            receiveAccountId = businessContract.getAccountInfoId();
        }
        CustomerContract customerContract = customerContracts.get(0);
        Map<String, Object> collectionResult = accountInfoSupport.executeCollection(ExecuteCollectionReqDto.builder().payAccountInfoId(customerContract.getAccountInfoId()).receiveAccountInfoId(receiveAccountId).amount(collectionInfoDto.getAmount()).build());
        CollectionRecord collectionRecord = CollectionInfoAssembler.INSTANCE.toRecord(businessContract, customerContract, collectionInfoDto.getAmount());
        handleResult(collectionResult, collectionRecord);
        return null;
    }

    private void handleResult(Map<String, Object> result, CollectionRecord record) {
        record.setResult((Integer) result.get("result"));
        record.setAccountSerialNumber((String) result.get("accountSerialNumber"));
    }


    /**
     * 批量代收
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean batchCollection(List<CollectionInfoDto> collectionInfoDtoList) {
        if (CollectionUtil.isEmpty(collectionInfoDtoList)) {
            return false;
        }
        CollectionInfoDto collectionInfoDto = collectionInfoDtoList.get(0);
        String projectCode = collectionInfoDto.getProjectCode();
        BusinessContract businessContract = contractSupport.queryBusinessContract(projectCode);
        if (businessContract == null) {

        }
        businessContract.checkStatus();
        //校验商户账户信息
        accountInfoSupport.checkAccountInfo(businessContract.getAccountInfoId(), ACCOUNT_RULE_CODE);
        accountInfoSupport.checkAccountInfo(businessContract.getTempAccountInfoId(), ACCOUNT_RULE_CODE);
        //查询并校验客户合约
        List<CustomerContract> customerContracts = collectionDomainService.handleCustomer(collectionInfoDtoList);
        if (CollectionUtil.isEmpty(customerContracts)) {
            return false;
        }
        String receiveAccountId;
        if (StringUtils.isNoneBlank(businessContract.getTempAccountInfoId())) {
            receiveAccountId = businessContract.getTempAccountInfoId();
        } else {
            receiveAccountId = businessContract.getAccountInfoId();
        }
        List<ExecuteCollectionReqDto> paramDtos = customerContracts.stream().map(customerContract -> ExecuteCollectionReqDto.builder().payAccountInfoId(customerContract.getAccountInfoId()).receiveAccountInfoId(receiveAccountId).amount(collectionInfoDto.getAmount()).build()).collect(Collectors.toList());
        //调用核心接口代收
        accountInfoSupport.executeCollection(paramDtos);
        customerContracts.forEach(customerContract -> {
            CollectionRecord collectionRecord = CollectionInfoAssembler.INSTANCE.toRecord(businessContract, customerContract, collectionInfoDto.getAmount());
            //todo 优化为批量插入
            collectionRecordRepository.save(collectionRecord);
        });
        return true;
    }


    /**
     * 修改代收记录状态
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean updateCollectionRecordStatus(List<ExecuteCollectionReqDto> collectionInfoDtoList) {
        collectionInfoDtoList.forEach(e -> {
            CollectionRecord collectionRecord = CollectionInfoAssembler.INSTANCE.toEntity(e);
            collectionRecordRepository.updateStatus(collectionRecord);
        });
        return true;
    }
}
