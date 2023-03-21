package com.zantong.contract.adapter.api;

import io.swagger.annotations.Api;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xulingfeng
 * @className BillingController
 * @description
 * @date 2023/2
 */
@Api("签约接口")
@FeignClient("businessContract")
@RequestMapping("/business/contract")
public interface BusinessContractServiceApi {

}
