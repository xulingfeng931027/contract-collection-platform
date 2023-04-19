package com.agree.collectionpay.infrastructure.pay.supportimpl;


import com.agree.collectionpay.application.support.AccountInfoSupport;
import com.agree.collectionpay.domain.pay.payableinfo.entity.PayableInfo;
import com.agree.collectionpay.domain.pay.valueobject.AccountInfo;
import com.agree.collectionpay.domain.pay.valueobject.PayResult;
import org.springframework.stereotype.Service;

/**
 * @author xulingfeng
 * 
 * @description 防腐层  调用账户系统
 * 
 */
@Service
public class AccountInfoSupportImpl implements AccountInfoSupport {
    /**
     * 执行收款
     *
     * @return
     */
    @Override
    public PayResult executePay(PayableInfo payableInfo) {
        return null;
    }

    /**
     * 单个校验账户信息
     *
     * @param accountId
     */
    @Override
    public boolean checkAccountInfo(String accountId) {
        return false;
    }

    /**
     * 单个校验账户信息
     *
     * @param accountId
     */
    @Override
    public AccountInfo queryAccountInfo(String accountId) {
        return null;
    }
}
