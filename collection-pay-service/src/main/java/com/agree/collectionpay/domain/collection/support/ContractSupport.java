package com.agree.collectionpay.domain.collection.support;

import com.agree.collectionpay.domain.collection.valueobject.CommercialTenantContract;
import com.agree.collectionpay.domain.collection.valueobject.CustomerContract;

import java.util.List;

/**
 * @author xulingfeng
 * 
 * @description 防腐层  调用签约服务
 * 
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
