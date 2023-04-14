package com.agree.contract.infrastructure.contract.supportImpl;


import com.agree.contract.application.contract.support.AccountInfoSupport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author xulingfeng
 * @description 模拟调用核心系统
 * 
 */
@Service
@Slf4j
public class AccountInfoSupportImpl implements AccountInfoSupport {


    /**
     * 校验账户信息
     *
     * @param accountId
     * @return
     */
    @Override
    public void checkAccountInfo(String accountId) {

    }
}