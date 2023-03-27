package com.zantong.pay.infrastructure.payRecord.supportImpl;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author xulingfeng
 * @description 模拟调用核心系统
 * @date 2022/9/11
 */
@Service
@Slf4j
public class AccountInfoSupportImpl implements AccountInfoSupport {


    /**
     * 校验账户信息
     *
     * @param accountId
     * @param ruleCode
     * @return
     */
    @Override
    public void checkAccountInfo(String accountId, String ruleCode) {

    }

    /**
     * 批量校验账户信息
     *
     * @param accountId
     * @param ruleCode
     * @return
     */
    @Override
    public void checkAccountInfo(List<String> accountId, String ruleCode) {

    }

    /**
     * 执行收款
     *
     * @param payAccountId
     * @param receiveAccountId
     * @param amount
     * @return
     */
    @Override
    public Map<String, Object> executeCollection(String payAccountId, String receiveAccountId, BigDecimal amount) {
        return null;
    }
}