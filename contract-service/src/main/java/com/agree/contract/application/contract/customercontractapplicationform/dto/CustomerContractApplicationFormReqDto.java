package com.agree.contract.application.contract.customercontractapplicationform.dto;

import com.agree.contract.domain.contract.commercialtenantcontract.entity.CommercialTenantContract;
import com.agree.contract.domain.contract.valueobject.AccountInfo;
import com.agree.contract.domain.contract.valueobject.CustomerInfo;
import com.agree.contract.domain.contract.valueobject.enumType.ChargeTypeEnum;
import com.agree.contract.domain.contract.valueobject.enumType.ContractApplicationFormStatusEnum;
import com.agree.contract.domain.contract.valueobject.enumType.SigningMode;
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
     * 收费种类
     */
    private ChargeTypeEnum chargeType;
    /**
     * 签约模式
     */
    private SigningMode signingMode;
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
