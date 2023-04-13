package com.agree.contract.application.modulecontract.customerContractApplicationForm.dto;

import com.agree.contract.domain.modulecontract.commercialTenantContract.entity.CommercialTenantContract;
import com.agree.contract.domain.modulecontract.valueobject.AccountInfo;
import com.agree.contract.domain.modulecontract.valueobject.CustomerInfo;
import com.agree.contract.domain.modulecontract.valueobject.enumType.AgencyTypeEnum;
import com.agree.contract.domain.modulecontract.valueobject.enumType.ChargeTypeEnum;
import com.agree.contract.domain.modulecontract.valueobject.enumType.ContractApplicationFormStatusEnum;
import lombok.Data;

/**
 * @author xulingfeng
 * 
 * @description
 */
@Data
public class CustomerContractApplicationFormReqDto {

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
