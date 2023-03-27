package com.zantong.contract.adapter.web;

import com.zantong.contract.application.CommercialTenantContract.dto.CommercialTenantContractDto;
import com.zantong.contract.application.CommercialTenantContract.support.api.CommercialTenantContractServiceApi;
import com.zantong.contract.application.CommercialTenantContractApplicationForm.dto.CommercialTenantContractApplicationFormDto;
import com.zantong.contract.application.CommercialTenantContractApplicationForm.service.CommercialTenantContractApplicationFormService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xulingfeng
 * @className BillingController
 * @description
 * @date 2023/2
 * todo 加统一异常处理和统一返回结构定义 事件发布统一接口的定义
 */
@Api("签约接口")
@RestController
public class CommercialTenantContractController implements CommercialTenantContractServiceApi {

    @Autowired
    private CommercialTenantContractApplicationFormService commercialTenantContractApplicationFormService;

    /**
     * 商户签约
     * @param commercialTenantContractApplicationFormDto
     * @return
     */
    @PostMapping("/signContract")
    public CommercialTenantContractApplicationFormDto signContract(@RequestBody @Validated CommercialTenantContractApplicationFormDto commercialTenantContractApplicationFormDto) {
        return commercialTenantContractApplicationFormService.signContract(commercialTenantContractApplicationFormDto);
    }

    @Override
    public CommercialTenantContractDto queryContract(@RequestParam String userCode, @RequestParam String projectCode) {
        return null;
    }
}
