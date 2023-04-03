package com.agree.pay.application.payRecord.support;

import com.agree.pay.application.payRecord.dto.CollectionParamDto;
import com.alibaba.fastjson2.JSONObject;

/**
 * @author xulingfeng
 * @className NumberSupport
 * @description 防腐层  调用账户系统
 * @date 2022/9/11
 */
public interface AccountInfoSupport {
    /**
     * 校验账户信息
     *
     * @param accountId
     * @return
     */
    void checkAccountInfo(String accountId);

    /**
     * 执行收款
     *
     * @return
     */
    JSONObject executeCollection(CollectionParamDto collectionParamDto);

}
