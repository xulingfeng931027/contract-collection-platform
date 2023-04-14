package com.agree.contract.application.contract.support;

/**
 * @author xulingfeng
 * @description 核心系统防腐层
 * 
 */
public interface AccountInfoSupport {
    /**
     * 调用核心系统校验账户信息
     *
     * @param accountId
     * @return
     */
    void checkAccountInfo(String accountId);


}
