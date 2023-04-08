package com.agree.contract.infrastructure.modulecontract.supportImpl;


import com.agree.contract.application.modulecontract.support.CustomerInfoSupport;
import com.agree.contract.domain.modulecontract.valueobject.CustomerInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author xulingfeng
 * @description 客户系统防腐层
 * @date 2022/9/11
 */
@Service
@Slf4j
public class CustomerInfoSupportImpl implements CustomerInfoSupport {

    /**
     * 查询客户信息
     *
     * @param idCard
     * @return
     */
    @Override
    public CustomerInfo queryCustomerInfo(String idCard) {
        return null;
    }
}