package com.zantong.contract.application.CommercialTenantContract.support.api;

import com.zantong.contract.application.CommercialTenantContract.dto.CommercialTenantContractDto;
import io.swagger.annotations.Api;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xulingfeng
 * @className BillingController
 * @description
 * @date 2023/2
 */
@Api("签约接口")
@FeignClient("CommercialTenantContract")
@RequestMapping("/commercia/tenant/contract/contract")
public interface CommercialTenantContractServiceApi {

    @GetMapping("/queryContract")
    CommercialTenantContractDto queryContract(@RequestParam String userCode, @RequestParam String projectCode);
}
