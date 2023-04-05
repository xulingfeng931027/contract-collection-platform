package com.agree.contract.interfaces.web;

import com.agree.contract.application.CommercialTenantContract.dto.CommercialTenantContractDto;
import com.agree.contract.application.CommercialTenantContract.support.api.CommercialTenantContractServiceApi;
import com.agree.contract.application.CommercialTenantContractApplicationForm.dto.CommercialTenantContractApplicationFormReqDto;
import com.agree.contract.application.CommercialTenantContractApplicationForm.service.CommercialTenantContractApplicationFormService;
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
     * @param commercialTenantContractApplicationFormReqDto
     * @return
     */
    @PostMapping("/agencyContract")
    public CommercialTenantContractApplicationFormReqDto agencyContract(@RequestBody @Validated CommercialTenantContractApplicationFormReqDto commercialTenantContractApplicationFormReqDto) {
        return commercialTenantContractApplicationFormService.agencyContract(commercialTenantContractApplicationFormReqDto);
    }

    @Override
    public CommercialTenantContractDto queryContract(@RequestParam String userCode, @RequestParam String projectCode) {
        return null;
    }
}