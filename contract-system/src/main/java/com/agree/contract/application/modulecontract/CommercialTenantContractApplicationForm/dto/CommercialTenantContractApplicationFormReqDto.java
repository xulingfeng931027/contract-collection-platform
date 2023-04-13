package com.agree.contract.application.modulecontract.CommercialTenantContractApplicationForm.dto;

import com.agree.contract.domain.modulecontract.valueobject.enumType.ChargeTypeEnum;
import com.agree.contract.domain.modulecontract.valueobject.enumType.FundGatherModeEnum;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * todo dto的定义
 *    1.dto一般分为reqDto和resDto
 *     如:签约成功后,一般不会返回的所有的申请单信息,可能造成数据泄露,建议分别定义reqDto和resDto
 *    2.dto一般可以通过添加注解来实现参数校验,与业务无关的参数校验可以放在这里.
 *     如:参数不能为空,字符串的长度,数字的范围
 *
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
