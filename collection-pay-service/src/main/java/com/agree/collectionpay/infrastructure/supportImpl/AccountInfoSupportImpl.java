package com.agree.collectionpay.infrastructure.supportImpl;


import com.agree.collectionpay.domain.collection.collectionInfo.entity.CollectionInfo;
import com.agree.collectionpay.domain.collection.support.AccountInfoSupport;
import com.agree.collectionpay.domain.collection.valueobject.CollectionResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xulingfeng
 * @description 模拟调用核心系统
 * 
 */
@Service
@Slf4j
public class AccountInfoSupportImpl implements AccountInfoSupport {


    /**
     * 执行单笔收款
     * 调用核心系统
     * @return
     */
    @Override
    public CollectionResult executeCollection(CollectionInfo collectionInfo) {
        return null;
    }

    /**
     * 批量执行收款
     *
     * @return
     */
    @Override
    public void executeCollection(List<CollectionInfo> collectionInfoList) {
    }

    /**
     * 批量校验账户信息
     *
     * @param accountId 账户id
     * @return
     */
    @Override
    public void checkAccountInfo(List<String> accountId) {

    }

    /**
     * 单个校验账户信息
     *
     * @param accountId
     */
    @Override
    public void checkAccountInfo(String accountId) {

    }


}