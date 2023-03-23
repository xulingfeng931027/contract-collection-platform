package com.zantong.collection.application.support;

import com.zantong.collection.application.dto.CollectionParamDto;

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
     * 校验账户信息
     *
     * @param number
     * @return
     */
    void checkAccountInfo(String number, String ruleCode);

    /**
     * 执行收款
     *
     * @return
     */
    Map<String, Object> executeCollection(CollectionParamDto collectionParamDto);

    /**
     * 批量执行收款
     *
     * @return
     */
    boolean executeCollection(List<CollectionParamDto> collectionParamDto);
}
