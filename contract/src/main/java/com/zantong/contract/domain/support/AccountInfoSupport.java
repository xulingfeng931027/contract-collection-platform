package com.zantong.contract.domain.support;

import java.math.BigDecimal;
import java.util.Map;

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
    void checkAccountInfo(String accountId,String ruleCode);

    /**
     * 执行收款
     *
     * @return
     */
    Map<String,Object> executeCollection(String payAccountId,String receiveAccountId,  BigDecimal amount);

}
