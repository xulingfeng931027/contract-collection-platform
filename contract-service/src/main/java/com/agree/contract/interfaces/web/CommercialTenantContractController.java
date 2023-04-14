package com.agree.contract.interfaces.web;

import com.agree.contract.application.contract.commercialtenantcontractapplicationform.dto.CommercialTenantContractApplicationFormReqDto;
import com.agree.contract.application.contract.commercialtenantcontractapplicationform.dto.CommercialTenantContractApplicationFormResDto;
import com.agree.contract.application.contract.service.CommercialTenantContractApplicationFormService;
import com.agree.contract.domain.contract.commercialtenantcontract.entity.CommercialTenantContract;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author xulingfeng
 * @description 商户签约
 * todo 使用  com.agree.contract.interfaces.advice.ResponseAdvice 进行了接口返回结构的统一封装
 *       com.agree.contract.interfaces.advice.GlobalExceptionAdvice 进行了全局异常的统一处理
 *       用户接口层可以包括消息消费,定时任务,用户rest接口封装等.
 *       还有jwt,权限校验,出入参加解密,日志记录等 的切面处理
 */
@Api("签约接口")
@RestController
@RequestMapping("/commercia/tenant/contract")
public class CommercialTenantContractController {

    @Autowired
    private CommercialTenantContractApplicationFormService commercialTenantContractApplicationFormService;

    /**
     * 商户签约
     *
     * @param commercialTenantContractApplicationFormReqDto
     * @return
     */
    @PostMapping("/agency")
    public CommercialTenantContractApplicationFormResDto agencyContract(@RequestBody @Validated CommercialTenantContractApplicationFormReqDto commercialTenantContractApplicationFormReqDto) {
        return commercialTenantContractApplicationFormService.agencyContract(commercialTenantContractApplicationFormReqDto);
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
