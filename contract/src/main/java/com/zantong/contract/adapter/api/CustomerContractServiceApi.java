package com.zantong.contract.adapter.api;

import com.zantong.contract.application.dto.CustomerContractDto;
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
@FeignClient("contract")
@RequestMapping("/customer/contract")
public interface CustomerContractServiceApi {


    @GetMapping("/queryContract")
    CustomerContractDto queryContract(@RequestParam String userCode, @RequestParam String projectCode);

}
