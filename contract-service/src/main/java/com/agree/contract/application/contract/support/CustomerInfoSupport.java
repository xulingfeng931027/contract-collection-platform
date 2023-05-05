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
     * @param idCard 身份证号
     * @return 客户信息
     */
    CustomerInfo queryCustomerInfo(String idCard);


}
