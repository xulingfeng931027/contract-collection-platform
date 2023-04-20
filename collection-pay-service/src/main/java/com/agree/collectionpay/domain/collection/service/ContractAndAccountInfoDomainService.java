package com.agree.collectionpay.domain.collection.service;

import com.agree.collectionpay.domain.collection.collectionInfo.entity.CollectionInfo;
import com.agree.collectionpay.domain.collection.support.AccountInfoSupport;
import com.agree.collectionpay.domain.collection.support.ContractSupport;
import com.agree.collectionpay.domain.collection.valueobject.CustomerContract;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
     * @param collectionInfoList 代收信息
     * @return 客户合约列表
     */
    public List<CustomerContract> queryBatchAndCheckCustomerContractAndCustomerAccountInfo(List<CollectionInfo> collectionInfoList) {
        // 获取请求参数中的客户合约id列表
        List<String> customerContractIdList = collectionInfoList.stream().map(e -> e.getCustomerContract().getId())
                .collect(Collectors.toList());

        // 查询客户合约(从合约系统获取)
        List<CustomerContract> customerContractList = contractSupport.queryCustomerContract(customerContractIdList);
        // 校验客户合约
        customerContractList.forEach(CustomerContract::statusIfValid);

        // 校验客户账户 (调用核心系统)
        List<String> customerAccountIds = customerContractList.stream().map(e -> e.getCustomerAccountInfo().getId())
                .collect(Collectors.toList());
        accountInfoSupport.checkAccountInfo(customerAccountIds);
        return customerContractList;
    }


    /**
     * 校验单个客户合约和客户账户信息
     *
     * @param collectionInfo 代收信息
     * @return 客户合约列表
     */
    public CustomerContract querySingleAndCheckCustomerContractAndCustomerAccountInfo(CollectionInfo collectionInfo) {
        return queryBatchAndCheckCustomerContractAndCustomerAccountInfo(Lists.newArrayList(collectionInfo)).get(0);
    }


    /*
    *  参考与建议：
    *     避免隐式修改参数， 默认传入的参数都是不可变的。方法的入参禁止被修改，如果需要返回数据，需要构造新的返回对象进行返回，避免入参在下一步被直接使用产生问题。
          说明：在领域层，从repository或者api中调用方法是有返回List、Set等集合对象的可能的，同时这些集合对象也会参与后面的业务逻辑，传递到实体、领域服务中，
    *     那么我们就需要有一种方式，避免在另一个代码位置出现了意外修改集合对象的可能。
    * */
}
