package com.agree.contract.application.contract.commercialtenantcontract.dto;

import com.agree.contract.domain.contract.valueobject.enumType.ChargeTypeEnum;
import com.agree.contract.domain.contract.valueobject.enumType.ContractStatusEnum;
import lombok.Data;

/**
 * @author xulingfeng
 * 
 * @description 商户合约dto
 */
@Data
public class CommercialTenantContractResDto {

    /**
     * 合约id
     */
    private String id;
    /**
     * 合约申请单id
     */
    private String contractApplicationFormId;
    /**
     * 合约状态
     */
    private ContractStatusEnum status;
    /**
     * 收费种类
     */
    private ChargeTypeEnum chargeType;

}
