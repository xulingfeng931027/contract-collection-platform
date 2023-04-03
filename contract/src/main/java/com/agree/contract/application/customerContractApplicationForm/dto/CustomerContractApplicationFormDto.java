package com.agree.contract.application.customerContractApplicationForm.dto;

import com.agree.contract.domain.commercialTenantContract.entity.CommercialTenantContract;
import com.agree.contract.domain.valueobject.*;
import lombok.Data;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description
 */
@Data
public class CustomerContractApplicationFormDto {

    /**
     * 合约名称
     */
    private String name;

    /**
     * 合约申请单状态
     */
    private ContractApplicationFormStatusEnum status;
    /**
     * 收费种类  todo 具有明显的业务意义，应该用枚举
     */
    private ChargeTypeEnum chargeType;
    /**
     * 签约模式
     */
    private AgencyTypeEnum agencyTypeEnum;
    /**
     * 客户账户信息
     */
    private AccountInfo customerAccountInfo;

    /**
     * 商户合约
     */
    private CommercialTenantContract commercialTenantContract;
    /**
     * 客户信息
     */
    private CustomerInfo customerInfo;


}
