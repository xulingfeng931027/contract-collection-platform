package com.agree.contract.application.CommercialTenantContractApplicationForm.support;

/**
 * @author xulingfeng
 * @className NumberSupport
 * @description 防腐层  调用账户系统
 * @date 2022/9/11
 */
public interface AccountInfoSupport {
    /**
     * 校验账户信息
     *
     * @param accountId
     * @return
     */
    void checkAccountInfo(String accountId, String ruleCode);


}
