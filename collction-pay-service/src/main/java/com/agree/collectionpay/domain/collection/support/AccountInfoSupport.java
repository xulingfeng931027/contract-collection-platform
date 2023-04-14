package com.agree.collectionpay.domain.collection.support;

import com.agree.collectionpay.application.pay.payableInfo.dto.ExecutePayReqDto;
import com.agree.collectionpay.domain.collection.valueobject.AccountInfo;

import java.util.List;
import java.util.Map;

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
    Map<String, Object> executeCollection(ExecutePayReqDto ExecutePayReqDto);

    /**
     * 批量执行收款
     *
     * @return
     */
    boolean executeCollection(List<ExecutePayReqDto> ExecutePayReqDto);

    List<String> checkAccountInfo(List<String> accountId);

    /**
     * 单个校验账户信息
     *
     * @param accountId
     */
    void checkAccountInfo(String accountId);

    /**
     * 查询客户账户信息
     *
     * @param accountId
     */
    AccountInfo queryAccountInfo(String accountId);
}
