package com.agree.collectionpay.application.payRecord.support;


import com.agree.collectionpay.domain.valueobject.CommercialTenantContract;

/**
 * @author xulingfeng
 * @className NumberSupport
 * @description 防腐层  调用账户系统
 * @date 2022/9/11
 */
public interface CommercialTenantContractSupport {

        /**
        * 查询商户合约
        *
        * @return
        */
        CommercialTenantContract queryContract(String projectCode, String userCode);
}
