package com.agree.pay.infrastructure.supportImpl;


import com.agree.pay.application.payRecord.support.AccountInfoSupport;
import com.agree.pay.application.payableInfo.dto.ExecutePayReqDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
    public Map<String, Object> executeCollection(ExecutePayReqDto executeCollectionReqDto) {
        return null;
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