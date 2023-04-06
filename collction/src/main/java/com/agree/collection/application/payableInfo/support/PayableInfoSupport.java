package com.agree.collection.application.payableInfo.support;

import com.agree.pay.domain.payableInfo.entity.PayableInfo;

/**
 * @author xulingfeng
 * @date 2023/4/4
 * @description 防腐层  调用商户系统查询应缴信息
 */
public interface PayableInfoSupport {

    PayableInfo queryPayableInfo(String userCode, String commercialTenantContractId);
}
