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
 */
@Data
public class CommercialTenantContractApplicationFormReqDto {

    /**
     * 收费种类
     */
    @NotNull(message = "收费种类不能为空")
    private ChargeTypeEnum chargeType;
    /**
     * 手续费
     */
    @NotNull(message = "手续费不能为空")
    @Min(value = 0,message = "手续费必须大于0")
    private BigDecimal commissionCharge;
    /**
     * 资金归集模式
     */
    @NotNull(message = "资金归集模式不能为空")
    private FundGatherModeEnum fundGatherMode;
    /**
     * 结算账户信息
     */
    @NotBlank(message = "结算账户id不能为空")
    private String settlementAccountInfoId;

    /**
     * 暂存账户信息
     */
    @NotBlank(message = "暂存账户id不能为空")
    private String tempAccountInfoId;
    /**
     * 商户法人证件号
     */
    @NotBlank(message = "商户法人证件号不能为空")
    private String legalPersonNumber;

}
