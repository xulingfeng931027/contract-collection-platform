package com.agree.collection.application.payRecord.support;

import com.agree.pay.domain.valueobject.CommercialTenantContract;

/**
 * @author xulingfeng
 * @className NumberSupport
 * @description 防腐层  调用账户系统
 * @date 2022/9/11
 */
public interface CommercialTenantContractSupport {

        /**
        * 查询合同信息
        *
        * @return
        */
        CommercialTenantContract queryContract(String projectCode, String userCode);
}
