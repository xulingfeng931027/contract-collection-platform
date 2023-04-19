package com.agree.collectionpay.application.pay.support;


import com.agree.collectionpay.domain.pay.valueobject.CommercialTenantContract;

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

}
