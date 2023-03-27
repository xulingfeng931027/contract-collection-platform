package com.zantong.collection.application.collectionrecord.support;

import com.zantong.collection.domain.valueobject.BusinessContract;
import com.zantong.collection.domain.valueobject.CustomerContract;

import java.util.List;

/**
 * @author xulingfeng
 * @className NumberSupport
 * @description 防腐层  调用账户系统
 * @date 2022/9/11
 */
public interface ContractSupport {
    /**
     * 查商户合约
     */
    BusinessContract queryBusinessContract(String projectCode);
    /**
     * 查客户合约
     */
    CustomerContract queryCustomerContract(String projectCode,String userCode);

    /**
     * 批量查客户合约
     */
    List<CustomerContract> queryCustomerContract(String projectCode, List<String> userCode);

}
