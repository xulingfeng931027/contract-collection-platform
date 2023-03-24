package com.zantong.pay.application.support;

import com.zantong.pay.domain.payRecordAggregation.valueobject.CustomerInfo;

/**
 * @author xulingfeng
 * @className NumberSupport
 * @description 防腐层  调用客户系统
 * @date 2022/9/11
 */
public interface CustomerInfoSupport {
    /**
     * 查询客户信息
     *
     * @return
     */
    CustomerInfo queryCustomerInfo(String idCard);


}
