package com.agree.collectionpay.application.modulepay.support;


import com.agree.collectionpay.domain.modulepay.valueobject.CommercialTenantContract;

/**
 * @author xulingfeng
 * @className NumberSupport
 * @description 防腐层  调用签约服务
 * @date 2022/9/11
 */
public interface ContractSupport {
    /**
     * 查商户合约
     */
    CommercialTenantContract queryCommercialTenantContract(String contractId);

}
