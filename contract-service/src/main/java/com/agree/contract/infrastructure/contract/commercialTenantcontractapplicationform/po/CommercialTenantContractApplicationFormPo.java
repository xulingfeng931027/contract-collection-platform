package com.agree.contract.infrastructure.contract.commercialTenantcontractapplicationform.po;

import com.agree.common.ddd.obj.AbstractPo;
import com.agree.contract.domain.contract.valueobject.enumType.ChargeMethodEnum;
import com.agree.contract.domain.contract.valueobject.enumType.ChargeTypeEnum;
import com.agree.contract.domain.contract.valueobject.enumType.ContractApplicationFormStatusEnum;
import com.agree.contract.domain.contract.valueobject.enumType.FundGatherModeEnum;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * @author xulingfeng
 * 
 * @description 商户合约申请单po
 */
@Data
@TableName(value = "commercial_tenant_contract_application_form", autoResultMap = true)
@SuperBuilder
public class CommercialTenantContractApplicationFormPo extends AbstractPo<String> {
    /**
     * 合约申请单状态
     */
    private ContractApplicationFormStatusEnum status;
    /**
     * 收费种类
     */
    private ChargeTypeEnum chargeType;

    /**
     * 资金归集模式
     */
    private FundGatherModeEnum fundGatherMode;
    /**
     * 手续费
     */
    private BigDecimal commissionCharge;
    /**
     * 扣费方式
     */
    private ChargeMethodEnum chargeMethod;
    /**
     * 结算账户信息
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private AccountInfoPo settlementAccountInfo;

    /**
     * 暂存账户信息
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private AccountInfoPo stagingAccountInfo;
    /**
     * 商户信息
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private CommercialTenantInfoPo commercialTenantInfo;

}
