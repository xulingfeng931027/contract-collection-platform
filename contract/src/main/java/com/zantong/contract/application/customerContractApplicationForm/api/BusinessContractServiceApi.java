package com.zantong.contract.application.customerContractApplicationForm.api;

import com.zantong.contract.application.CommercialTenantContractApplicationForm.dto.CommercialTenantContractApplicationFormDto;
import io.swagger.annotations.Api;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xulingfeng
 * @className BillingController
 * @description
 * @dat\/p=7kuk6kkkkkkkk-jp 2023/2
 */
@Api("签约接口")
@FeignClient("businessContract")
@RequestMapping("/business/contract")
public interface BusinessContractServiceApi {

    @GetMapping("/queryContract")
    CommercialTenantContractApplicationFormDto queryContract(@RequestParam String userCode, @RequestParam String projectCode);
}
