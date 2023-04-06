package com.agree.collectionpay.application.support;

import com.agree.collectionpay.application.payableInfo.dto.ExecutePayReqDto;
import com.agree.collectionpay.domain.valueobject.AccountInfo;

import java.util.List;
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
    Map<String, Object> executeCollection(ExecutePayReqDto ExecutePayReqDto);

    /**
     * 批量执行收款
     *
     * @return
     */
    boolean executeCollection(List<ExecutePayReqDto> ExecutePayReqDto);

    List<String> checkAccountInfo(List<String> accountId, String ruleCode);

    /**
     * 单个校验账户信息
     *
     * @param accountId
     * @param ruleCode
     */
    void checkAccountInfo(String accountId, String ruleCode);

    /**
     * 单个校验账户信息
     *
     * @param accountId
     * @param ruleCode
     */
    AccountInfo queryAccountInfo(String accountId);
}
