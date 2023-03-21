package com.zantong.contract.adapter.web;

import com.zantong.contract.adapter.api.BusinessContractServiceApi;
import com.zantong.contract.application.dto.BusinessContractDto;
import com.zantong.contract.application.service.BusinessContractService;
import com.zantong.contract.domain.repository.CustomerContractRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xulingfeng
 * @className BillingController
 * @description
 * @date 2023/2
 */
@Api("签约接口")
@RestController
public class BusinessContractController implements BusinessContractServiceApi {

    @Autowired
    private BusinessContractService contractService;
    @Autowired
    private CustomerContractRepository contractRepository;


    @PostMapping("/signContract")
    public BusinessContractDto signContract(BusinessContractDto businessContractDto) {
        return contractService.signContract(businessContractDto);
    }

}
