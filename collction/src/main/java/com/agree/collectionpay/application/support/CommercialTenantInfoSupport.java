package com.agree.collectionpay.application.support;

import com.agree.collectionpay.domain.valueobject.CommercialTenantInfo;

/**
 * @author xulingfeng
 * @className NumberSupport
 * @description 防腐层  调用商户系统
 * @date 2022/9/11
 */
public interface CommercialTenantInfoSupport {
    /**
     * 查询商户信息
     *
     * @return
     */
    CommercialTenantInfo queryBCommercialTenantInfo(String idCard);


}
