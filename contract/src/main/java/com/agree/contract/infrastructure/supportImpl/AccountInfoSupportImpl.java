package com.agree.contract.infrastructure.supportImpl;


import com.agree.contract.application.CommercialTenantContractApplicationForm.support.AccountInfoSupport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author xulingfeng
 * @description 模拟调用核心系统
 * @date 2022/9/11
 */
@Service
@Slf4j
public class AccountInfoSupportImpl implements AccountInfoSupport {


    /**
     * 校验账户信息
     *
     * @param accountId
     * @param ruleCode
     * @return
     */
    @Override
    public void checkAccountInfo(String accountId, String ruleCode) {

    }
}