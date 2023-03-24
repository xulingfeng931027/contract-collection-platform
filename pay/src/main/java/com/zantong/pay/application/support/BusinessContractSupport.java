package com.zantong.pay.application.support;

import com.zantong.pay.domain.payRecordAggregation.valueobject.BusinessContract;

/**
 * @author xulingfeng
 * @className NumberSupport
 * @description 防腐层  调用账户系统
 * @date 2022/9/11
 */
public interface BusinessContractSupport {

        /**
        * 查询合同信息
        *
        * @return
        */
        BusinessContract queryContract(String projectCode, String userCode);
}
