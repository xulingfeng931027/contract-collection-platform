package com.agree.contract.application.contract.support;

import com.agree.contract.domain.contract.valueobject.CustomerInfo;

/**
 * @author xulingfeng
 * 
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
