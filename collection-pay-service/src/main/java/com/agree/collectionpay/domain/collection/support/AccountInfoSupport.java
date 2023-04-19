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
     * 执行收款
     *
     * @return
     */

    CollectionResult executeCollection(CollectionInfo collectionInfo);

    /**
     * 批量执行收款
     *
     * @return
     */
    boolean executeCollection(List<CollectionInfo> collectionInfoList);

    List<String> checkAccountInfo(List<String> accountId);

    /**
     * 单个校验账户信息
     *
     * @param accountId
     */
    void checkAccountInfo(String accountId);

}
