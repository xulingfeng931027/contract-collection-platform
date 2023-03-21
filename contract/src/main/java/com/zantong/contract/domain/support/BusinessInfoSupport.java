package com.zantong.contract.domain.support;

import com.zantong.contract.domain.entity.valueobject.BusinessInfo;

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
    BusinessInfo queryBusinessInfo(String idCard);


}
