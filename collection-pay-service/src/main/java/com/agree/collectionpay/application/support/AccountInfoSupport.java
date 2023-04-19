package com.agree.collectionpay.application.support;

import com.agree.collectionpay.domain.pay.payableinfo.entity.PayableInfo;
import com.agree.collectionpay.domain.pay.valueobject.AccountInfo;
import com.agree.collectionpay.domain.pay.valueobject.PayResult;

/**
 * @author xulingfeng
 * 
 * @description 防腐层  调用账户系统
 * 
 */
public interface AccountInfoSupport {
    /**
     * 执行收款
     *
     * @return
     */
    PayResult executePay(PayableInfo payableInfo);

    /**
     * 单个校验账户信息
     *
     * @param accountId
     */
    boolean checkAccountInfo(String accountId);

    /**
     * 单个校验账户信息
     *
     * @param accountId
     */
    AccountInfo queryAccountInfo(String accountId);
}
