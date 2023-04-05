package com.agree.collection.application.collectionInfo.support;


import com.agree.collection.domain.valueobject.CommercialTenantInfo;

/**
 * @author xulingfeng
 * @className NumberSupport
 * @description 防腐层  调用商户系统
 * @date 2022/9/11
 */
public interface BusinessInfoSupport {
    /**
     * 查询商户信息
     *
     * @return
     */
    CommercialTenantInfo queryCommercialTenantInfo(String idCard);


}
