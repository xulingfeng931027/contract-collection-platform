package com.agree.collectionpay.application.modulepay.support;

import com.agree.collectionpay.application.modulepay.payableInfo.dto.ExecutePayReqDto;
import com.agree.collectionpay.domain.modulepay.valueobject.AccountInfo;

import java.util.List;
import java.util.Map;

/**
 * @author xulingfeng
 * @className NumberSupport
 * @description 防腐层  调用账户系统
 * 
 */
public interface AccountInfoSupport {
    /**
     * 执行收款
     *
     * @return
     */
    Map<String, Object> executeCollection(ExecutePayReqDto ExecutePayReqDto);


    /**
     * 单个校验账户信息
     *
     * @param accountId
     */
    void checkAccountInfo(String accountId);

    /**
     * 单个校验账户信息
     *
     * @param accountId
     */
    AccountInfo queryAccountInfo(String accountId);
}
