package com.agree.contract.interfaces.web;

import com.agree.contract.application.modulecontract.CommercialTenantContractApplicationForm.dto.CommercialTenantContractApplicationFormReqDto;
import com.agree.contract.application.modulecontract.service.CommercialTenantContractApplicationFormService;
import com.agree.contract.application.modulecontract.support.api.CommercialTenantContractServiceApi;
import com.agree.contract.domain.modulecontract.commercialTenantContract.entity.CommercialTenantContract;
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
 * @date 2023/3/11
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
    public CommercialTenantContract queryContractById(@RequestParam String contractId) {
        return null;
    }
}
