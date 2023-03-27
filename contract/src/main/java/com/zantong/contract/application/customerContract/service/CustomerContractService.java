package com.zantong.contract.application.customerContract.service;

import com.zantong.contract.domain.commercialTenantContract.repository.CommercialTenantContractRepository;
import com.zantong.contract.domain.support.AccountInfoSupport;
import com.zantong.contract.domain.support.CommercialTenantInfoSupport;
import com.zantong.contract.domain.support.CustomerInfoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xulingfeng
 * @description 签约服务
 * @date 2023/2
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



}
