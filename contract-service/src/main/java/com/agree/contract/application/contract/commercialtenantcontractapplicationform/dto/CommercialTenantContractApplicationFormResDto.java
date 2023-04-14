package com.agree.contract.application.contract.commercialtenantcontractapplicationform.dto;

import com.agree.contract.domain.contract.valueobject.enumType.ChargeTypeEnum;
import com.agree.contract.domain.contract.valueobject.enumType.FundGatherModeEnum;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author xulingfeng
 * 
 */
@Data
public class CommercialTenantContractApplicationFormResDto {
    /**
     * 申请单id
     */
    private String id;
    /**
     * 收费种类
     */
    @NotNull
    private ChargeTypeEnum chargeType;
    /**
     * 手续费
     */
    @NotNull
    @Min(0)
    private BigDecimal commissionCharge;
    /**
     * 资金归集模式
     */
    @NotNull
    private FundGatherModeEnum fundGatherMode;
    /**
    /**
     * 商户法人证件号
     */
    @NotBlank
    private String legalPersonNumber;

}
