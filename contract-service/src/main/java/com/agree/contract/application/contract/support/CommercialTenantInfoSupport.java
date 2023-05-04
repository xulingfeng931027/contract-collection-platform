package com.agree.contract.application.contract.support;

import com.agree.contract.domain.contract.exception.ContractException;
import com.agree.contract.domain.contract.valueobject.CommercialTenantInfo;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xulingfeng
 * 
 * @description 商户系统防腐层接口
 */
public interface CommercialTenantInfoSupport {
    /**
     * 查询商户信息
     * 调用三方商户信息系统接口
     * @return 商户信息
     */
    @Transactional(rollbackFor = ContractException.class)
    CommercialTenantInfo queryCommercialTenantInfo(String idCard);
}
