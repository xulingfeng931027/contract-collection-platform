package com.agree.contract.infrastructure.commercialTenantContract.po;

import com.agree.common.api.AbstractPo;
import com.agree.contract.domain.valueobject.*;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xulingfeng
 * @date 2023/3/17
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

    private Date createTime;

    private Date updateTime;

}
