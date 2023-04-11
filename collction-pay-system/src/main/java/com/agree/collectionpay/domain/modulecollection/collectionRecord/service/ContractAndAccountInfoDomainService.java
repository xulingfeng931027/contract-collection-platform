package com.agree.collectionpay.domain.modulecollection.collectionRecord.service;

import com.agree.collectionpay.domain.modulecollection.collectionInfo.entity.CollectionInfo;
import com.agree.collectionpay.domain.modulecollection.support.AccountInfoSupport;
import com.agree.collectionpay.domain.modulecollection.support.ContractSupport;
import com.agree.collectionpay.domain.modulecollection.valueobject.CustomerContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xulingfeng
 * @description 签约和账户信息领域服务
 */
@Service
public class ContractAndAccountInfoDomainService {
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
    public void checkCustomerContractAndCustomerAccountInfo(List<CollectionInfo> collectionInfoList) {
        // 获取请求参数中的客户合约id列表
        List<String> customerContractIdList = collectionInfoList.stream().map(e -> e.getCustomerContract().getId())
                .collect(Collectors.toList());

        // 查询客户合约(从合约系统获取)
        List<CustomerContract> customerContractList = contractSupport.queryCustomerContract(customerContractIdList);
        // 校验客户合约
        customerContractList.forEach(CustomerContract::statusIfValid);

        // 校验客户账户 (调用核心系统)
        accountInfoSupport.checkAccountInfo(customerContractList.stream().map(e -> e.getCustomerAccountInfo().getId())
                .collect(Collectors.toList()));

        // 完善代收信息中的客户合约属性
        completeCustomerContract(collectionInfoList, customerContractList);

    }

    /**
     * 完善代收信息中的客户合约属性
     *
     * @param collectionInfoList   代收信息列表
     * @param customerContractList 客户合约列表
     */
    private void completeCustomerContract(List<CollectionInfo> collectionInfoList, List<CustomerContract> customerContractList) {
        Map<String, CustomerContract> map = customerContractList.stream().collect(Collectors.toMap(CustomerContract::getId, e -> e));
        collectionInfoList.forEach(e -> e.completeCustomerContract(map.get(e.getCustomerContract().getId())));
    }
}
