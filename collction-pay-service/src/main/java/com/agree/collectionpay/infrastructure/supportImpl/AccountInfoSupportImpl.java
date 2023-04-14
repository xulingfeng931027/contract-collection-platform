package com.agree.collectionpay.infrastructure.supportImpl;


import com.agree.collectionpay.application.pay.payableInfo.dto.ExecutePayReqDto;
import com.agree.collectionpay.domain.collection.support.AccountInfoSupport;
import com.agree.collectionpay.domain.collection.valueobject.AccountInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author xulingfeng
 * @description 模拟调用核心系统
 * 
 */
@Service
@Slf4j
public class AccountInfoSupportImpl implements AccountInfoSupport {


    /**
     * 执行收款
     *
     * @param ExecutePayReqDto
     * @return
     */
    @Override
    public Map<String, Object> executeCollection(ExecutePayReqDto ExecutePayReqDto) {
        return null;
    }

    /**
     * 批量执行收款
     *
     * @param ExecutePayReqDto
     * @return
     */
    @Override
    public boolean executeCollection(List<ExecutePayReqDto> ExecutePayReqDto) {
        return false;
    }

    @Override
    public List<String> checkAccountInfo(List<String> accountId) {
        return null;
    }

    /**
     * 单个校验账户信息
     *
     * @param accountId
     */
    @Override
    public void checkAccountInfo(String accountId) {

    }


    /**
     * 查询账户信息
     *
     * @param accountId
     */
    @Override
    public AccountInfo queryAccountInfo(String accountId) {
        return null;
    }
}