package com.agree.collectionpay.domain.collectionRecord.service;

import cn.hutool.core.collection.CollectionUtil;
import com.agree.collectionpay.application.support.AccountInfoSupport;
import com.agree.collectionpay.application.support.ContractSupport;
import com.agree.collectionpay.domain.collectionInfo.entity.CollectionInfo;
import com.agree.collectionpay.domain.valueobject.CustomerContract;
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
    /**
     * 核心系统规则校验码
     */
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
     * @param collectionInfoList
     */
    @Transactional(rollbackFor = Exception.class)
    public void checkCustomerContractAndCustomerAccountInfo(List<CollectionInfo> collectionInfoList) {
        if (CollectionUtil.isEmpty(collectionInfoList)) {
            return;
        }
        //批量查询客户合约
        List<String> customerContractIdList = collectionInfoList.stream().map(e -> e.getCustomerContract().getId()).collect(Collectors.toList());
        List<CustomerContract> customerContractList = contractSupport.queryCustomerContract(customerContractIdList);
        completeCustomerContract(collectionInfoList, customerContractList);
        //校验客户合约
        customerContractList.forEach(CustomerContract::statusIfValid);
        //校验客户账户
        accountInfoSupport.checkAccountInfo(collectionInfoList.stream().map(e -> e.getCustomerContract().getCustomerAccountInfo().getId()).collect(Collectors.toList()), ACCOUNT_RULE_CODE);
    }

    /**
     * 完善客户合约信息
     *
     * @param collectionInfoList
     * @param customerContractList
     */
    private void completeCustomerContract(List<CollectionInfo> collectionInfoList, List<CustomerContract> customerContractList) {
        Map<String, CustomerContract> map = customerContractList.stream().collect(Collectors.toMap(CustomerContract::getId, e -> e));
        collectionInfoList.forEach(e -> e.completeCustomerContract(map.get(e.getCustomerContract().getId())));
    }
}
