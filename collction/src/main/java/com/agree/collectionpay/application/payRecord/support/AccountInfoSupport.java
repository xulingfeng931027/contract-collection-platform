package com.agree.collectionpay.application.payRecord.support;

import com.agree.collectionpay.application.payableInfo.dto.ExecutePayReqDto;

import java.util.Map;

/**
 * @author xulingfeng
 * @className NumberSupport
 * @description 防腐层  调用账户系统
 * @date 2022/9/11
 */
public interface AccountInfoSupport {
    /**
     * 执行收款
     *
     * @return
     */
    Map<String, Object> executeCollection(ExecutePayReqDto executeCollectionReqDto);


    /**
     * 单个校验账户信息
     *
     * @param accountId
     * @param ruleCode
     */
    void checkAccountInfo(String accountId, String ruleCode);
}
