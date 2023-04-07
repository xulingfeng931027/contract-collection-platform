package com.agree.contract.infrastructure.commercialTenantContractApplicationForm.po;

import com.agree.common.api.AbstractPo;
import com.agree.contract.domain.valueobject.*;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description
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
     * 收费种类  todo 具有明显的业务意义，应该用枚举
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
    private AccountInfo settlementAccountInfo;

    /**
     * 暂存账户信息
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private AccountInfo stagingAccountInfo;
    /**
     * 商户信息
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private CommercialTenantInfo commercialTenantInfo;

}
