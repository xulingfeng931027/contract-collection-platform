package com.agree.contract.infrastructure.contract.commercialtenantcontract.po;

import com.agree.common.ddd.obj.AbstractPo;
import com.agree.contract.domain.contract.valueobject.enumType.ChargeTypeEnum;
import com.agree.contract.domain.contract.valueobject.enumType.ContractStatusEnum;
import com.agree.contract.domain.contract.valueobject.enumType.FundGatherModeEnum;
import com.agree.contract.infrastructure.contract.commercialTenantcontractapplicationform.po.AccountInfoPo;
import com.agree.contract.infrastructure.contract.commercialTenantcontractapplicationform.po.CommercialTenantInfoPo;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * @author xulingfeng
 * 
 * @description 客户合约
 */
@Data
@TableName("commercial_tenant_contract")
@SuperBuilder
public class CommercialTenantContractPo extends AbstractPo<String> {
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

    /**
     * 资金归集模式
     */
    private FundGatherModeEnum fundGatherMode;
    /**
     * 手续费
     */
    private BigDecimal commissionCharge;
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

    /**
     * 商户法人证件号
     */
    private String legalPersonNumber;

}
