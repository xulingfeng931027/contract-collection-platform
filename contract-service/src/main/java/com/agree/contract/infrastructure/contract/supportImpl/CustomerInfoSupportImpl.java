package com.agree.contract.infrastructure.contract.supportImpl;


import com.agree.contract.application.contract.support.CustomerInfoSupport;
import com.agree.contract.domain.contract.valueobject.CustomerInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author xulingfeng
 * @description 客户系统防腐层接口实现
 * 
 */
@Service
@Slf4j
public class CustomerInfoSupportImpl implements CustomerInfoSupport {

    /**
     * 查询客户信息
     *
     * @param idCard 身份证号
     * @return 客户信息
     */
    @Override
    public CustomerInfo queryCustomerInfo(String idCard) {
        return null;
    }
}