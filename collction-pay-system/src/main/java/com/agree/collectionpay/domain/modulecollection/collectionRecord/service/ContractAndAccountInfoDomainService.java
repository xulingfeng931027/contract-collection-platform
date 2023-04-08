package com.agree.collectionpay.domain.modulecollection.collectionRecord.service;

import com.agree.collectionpay.domain.modulecollection.collectionInfo.entity.CollectionInfo;
import com.agree.collectionpay.domain.modulecollection.support.AccountInfoSupport;
import com.agree.collectionpay.domain.modulecollection.support.ContractSupport;
import com.agree.collectionpay.domain.modulecollection.valueobject.CustomerContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xulingfeng
 * @date 2023/3/22
 * @description 签约和账户信息领域服务
 */
@Service
public class ContractAndAccountInfoDomainService {
    private static final String ACCOUNT_RULE_CODE = "XXX";
    /**
     * 签约服务防腐层
     */
    @Autowired
    private ContractSupport contractSupport;
    /**
     * 核心系统防腐层
     */
    @Autowired
    private AccountInfoSupport accountInfoSupport;

    /**
     * 批量校验客户合约和客户账户信息
     *
     * @param collectionInfoList 代收信息
     */
    @Transactional(rollbackFor = Exception.class)
    public void checkCustomerContractAndCustomerAccountInfo(List<CollectionInfo> collectionInfoList) {
        // 获取参数中的客户合约id列表
        List<String> customerContractIdList = collectionInfoList.stream().map(e -> e.getCustomerContract().getId())
                .collect(Collectors.toList());

        // 查询客户合约(从合约系统获取)
        List<CustomerContract> customerContractList = contractSupport.queryCustomerContract(customerContractIdList);
        // 校验客户合约
        customerContractList.forEach(CustomerContract::statusIfValid);

        // 校验客户账户 (调用核心系统)
        accountInfoSupport.checkAccountInfo(customerContractList.stream().map(e -> e.getCustomerAccountInfo().getId())
                .collect(Collectors.toList()));

        // 完善（代收信息在中的）客户合约
        completeCustomerContract(collectionInfoList, customerContractList);

    }

    /**
     * 完善（代收信息在中的）客户合约
     *
     * @param collectionInfoList
     * @param customerContractList
     */
    private void completeCustomerContract(List<CollectionInfo> collectionInfoList, List<CustomerContract> customerContractList) {
        Map<String, CustomerContract> map = customerContractList.stream().collect(Collectors.toMap(CustomerContract::getId, e -> e));
        collectionInfoList.forEach(e -> e.completeCustomerContract(map.get(e.getCustomerContract().getId())));
    }
}