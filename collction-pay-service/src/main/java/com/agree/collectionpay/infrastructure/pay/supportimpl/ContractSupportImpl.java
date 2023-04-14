package com.agree.collectionpay.infrastructure.pay.supportimpl;


import com.agree.collectionpay.application.pay.support.ContractSupport;
import com.agree.collectionpay.domain.pay.valueobject.CommercialTenantContract;

/**
 * @author xulingfeng
 * 
 * @description 防腐层  调用签约服务
 * 
 */
public class ContractSupportImpl implements ContractSupport {
    /**
     * 查商户合约
     *
     * @param contractId
     */
    @Override
    public CommercialTenantContract queryCommercialTenantContract(String contractId) {
        return null;
    }
}
