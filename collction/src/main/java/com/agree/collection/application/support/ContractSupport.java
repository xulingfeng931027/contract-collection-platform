package com.agree.collection.application.support;

import com.agree.collection.domain.valueobject.CommercialTenantContract;
import com.agree.collection.domain.valueobject.CustomerContract;

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
    CommercialTenantContract queryCommercialTenantContract(String contractId);

    /**
     * 批量查客户合约
     */
    List<CustomerContract> queryCustomerContract(List<String> customerContractIdList);

}
