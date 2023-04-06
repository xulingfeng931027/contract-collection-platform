package com.agree.collectionpay.application.collectionInfo.support;

import com.agree.collectionpay.application.collectionInfo.dto.ExecuteCollectionReqDto;

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
    Map<String, Object> executeCollection(ExecuteCollectionReqDto executeCollectionReqDto);

    /**
     * 批量执行收款
     *
     * @return
     */
    boolean executeCollection(List<ExecuteCollectionReqDto> executeCollectionReqDtos);

    List<String> checkAccountInfo(List<String> accountId, String ruleCode);

    /**
     * 单个校验账户信息
     *
     * @param accountId
     * @param ruleCode
     */
    void checkAccountInfo(String accountId, String ruleCode);
}
