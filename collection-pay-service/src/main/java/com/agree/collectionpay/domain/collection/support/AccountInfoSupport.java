package com.agree.collectionpay.domain.collection.support;

import com.agree.collectionpay.domain.collection.collectionInfo.entity.CollectionInfo;
import com.agree.collectionpay.domain.collection.valueobject.CollectionResult;

import java.util.List;

/**
 * @author xulingfeng
 * 
 * @description 防腐层  调用账户系统
 * 
 */
public interface AccountInfoSupport {
    /**
     * 执行单笔代收
     * @return
     */
    CollectionResult executeCollection(CollectionInfo collectionInfo);

    /**
     * 执行批量代收
     * @return
     */
    void executeCollection(List<CollectionInfo> collectionInfoList);

    /**
     * 批量校验账户信息
     * @param accountId 账户id
     * @return
     */
    void checkAccountInfo(List<String> accountId);

    /**
     * 校验账户信息
     *
     * @param accountId
     */
    void checkAccountInfo(String accountId);

}
