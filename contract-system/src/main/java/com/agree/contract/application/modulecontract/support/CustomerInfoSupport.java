package com.agree.contract.application.modulecontract.support;

import com.agree.contract.domain.modulecontract.valueobject.CustomerInfo;

/**
 * @author xulingfeng
 * @className NumberSupport
 * @description 防腐层  调用客户系统
 * 
 */
public interface CustomerInfoSupport {
    /**
     * 查询客户信息
     *
     * @return
     */
    CustomerInfo queryCustomerInfo(String idCard);


}
