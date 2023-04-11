package com.agree.collectionpay.infrastructure.modulepay.supportimpl;


import com.agree.collectionpay.application.modulepay.payableInfo.dto.ExecutePayReqDto;
import com.agree.collectionpay.application.modulepay.support.AccountInfoSupport;
import com.agree.collectionpay.domain.modulepay.valueobject.AccountInfo;

import java.util.List;
import java.util.Map;

/**
 * @author xulingfeng
 * @className NumberSupport
 * @description 防腐层  调用账户系统
 * 
 */
public class AccountInfoSupportImpl implements AccountInfoSupport {
    /**
     * 执行收款
     *
     * @param ExecutePayReqDto
     * @return
     */
    @Override
    public Map<String, Object> executeCollection(ExecutePayReqDto ExecutePayReqDto) {
        return null;
    }

    /**
     * 单个校验账户信息
     *
     * @param accountId
     */
    @Override
    public void checkAccountInfo(String accountId) {

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
