package com.agree.pay.application.payRecord.support;

import com.agree.pay.domain.valueobject.BusinessContract;

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
        BusinessContract queryContract(String projectCode, String userCode);
}
