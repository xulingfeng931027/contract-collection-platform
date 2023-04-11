package com.agree.contract.application.modulecontract.support.api;

import com.agree.contract.domain.modulecontract.commercialTenantContract.entity.CommercialTenantContract;
import io.swagger.annotations.Api;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xulingfeng
 * @className BillingController
 * @description
 * 
 */
@Api("签约接口")
@FeignClient("CommercialTenantContract")
@RequestMapping("/commercia/tenant/contract/contract")
public interface CommercialTenantContractServiceApi {

    @GetMapping("/queryContract")
    CommercialTenantContract queryContractById(@RequestParam String contractId);
}
