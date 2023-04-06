package com.agree.collectionpay.infrastructure.supportImpl;


import com.agree.collectionpay.application.collectionInfo.dto.ExecuteCollectionReqDto;
import com.agree.collectionpay.application.collectionInfo.support.AccountInfoSupport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author xulingfeng
 * @description 模拟调用核心系统
 * @date 2022/9/11
 */
@Service
@Slf4j
public class AccountInfoSupportImpl implements AccountInfoSupport {


    /**
     * 执行收款
     *
     * @param executeCollectionReqDto
     * @return
     */
    @Override
    public Map<String, Object> executeCollection(ExecuteCollectionReqDto executeCollectionReqDto) {
        return null;
    }

    /**
     * 批量执行收款
     *
     * @param executeCollectionReqDto
     * @return
     */
    @Override
    public boolean executeCollection(List<ExecuteCollectionReqDto> executeCollectionReqDto) {
        return false;
    }

    /**
     * 批量校验账户信息
     *
     * @param accountId
     * @param ruleCode
     * @return
     */
    @Override
    public List<String> checkAccountInfo(List<String> accountId, String ruleCode) {
        return new ArrayList<>();
    }

    /**
     * 单个校验账户信息
     *
     * @param accountId
     * @param ruleCode
     */
    @Override
    public void checkAccountInfo(String accountId, String ruleCode) {

    }
}