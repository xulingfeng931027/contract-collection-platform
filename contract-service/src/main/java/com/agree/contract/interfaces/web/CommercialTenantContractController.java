package com.agree.contract.interfaces.web;

import com.agree.contract.application.contract.commercialtenantcontractapplicationform.dto.CommercialTenantContractApplicationFormReqDto;
import com.agree.contract.application.contract.commercialtenantcontractapplicationform.dto.CommercialTenantContractApplicationFormResDto;
import com.agree.contract.application.contract.service.CommercialTenantContractApplicationFormService;
import com.agree.contract.domain.contract.commercialtenantcontract.entity.CommercialTenantContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author xulingfeng
 * @description 商户签约
 */
@RestController
@RequestMapping("/commercial/tenant/contract")
public class CommercialTenantContractController {

    @Autowired
    private CommercialTenantContractApplicationFormService commercialTenantContractApplicationFormService;

    /**
     * 商户签约
     *
     * @param commercialTenantContractApplicationFormReqDto
     * @return
     */
    @PostMapping("/signing")
    public CommercialTenantContractApplicationFormResDto commercialTenantSignContract(@RequestBody @Validated CommercialTenantContractApplicationFormReqDto commercialTenantContractApplicationFormReqDto) {
        return commercialTenantContractApplicationFormService.commercialTenantSignContract(commercialTenantContractApplicationFormReqDto);
    }

    /**
     * 根据id查商户合约
     *
     * @param contractId 合约id
     * @return
     */
    @GetMapping("/{contractId}")
    public CommercialTenantContract queryContractById(@PathVariable String contractId) {
        return null;
    }
}
