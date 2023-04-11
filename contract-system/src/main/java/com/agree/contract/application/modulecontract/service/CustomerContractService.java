package com.agree.contract.application.modulecontract.service;

import com.agree.contract.application.modulecontract.support.AccountInfoSupport;
import com.agree.contract.application.modulecontract.support.CommercialTenantInfoSupport;
import com.agree.contract.application.modulecontract.support.CustomerInfoSupport;
import com.agree.contract.domain.modulecontract.commercialTenantContract.repository.CommercialTenantContractRepository;
import com.agree.contract.domain.modulecontract.customercontract.entity.CustomerContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xulingfeng
 * @description 签约服务
 * 
 */
@Service
public class CustomerContractService {

    private static final String ACCOUNT_RULE_CODE = "XXX";
    @Autowired
    private CommercialTenantContractRepository commercialTenantContractRepository;
    @Autowired
    private AccountInfoSupport accountInfoSupport;
    @Autowired
    private CommercialTenantInfoSupport commercialTenantInfoSupport;
    @Autowired
    private CustomerInfoSupport customerInfoSupport;

    public CustomerContract queryCustomerContract(String userCode, String commercialTenantContractId) {
        return null;
    }


}
