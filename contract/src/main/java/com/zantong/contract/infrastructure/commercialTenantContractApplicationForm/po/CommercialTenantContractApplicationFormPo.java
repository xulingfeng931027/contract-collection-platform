package com.zantong.contract.infrastructure.commercialTenantContractApplicationForm.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.zantong.contract.domain.valueobject.AccountInfo;
import com.zantong.contract.domain.valueobject.CommercialTenantInfo;
import com.zantong.contract.domain.valueobject.ContractStatusEnum;
import com.zantong.contract.domain.valueobject.FundGatherModeEnum;
import lombok.Data;

import static com.baomidou.mybatisplus.annotation.IdType.ASSIGN_ID;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description
 */
@Data
@TableName(value = "business_contract", autoResultMap = true)
public class CommercialTenantContractApplicationFormPo {
    /**
     * 合约id
     */
    @TableId(type = ASSIGN_ID)
    private String id;
    /**
     * 合约名称
     */
    private String name;
    /**
     * 合约类型 todo 用枚举
     */
    private String type;
    /**
     * 合约状态
     */
    private ContractStatusEnum status;
    /**
     * 收费种类
     */
    private String chargeType;

    /**
     * 资金归集模式
     */
    private FundGatherModeEnum fundGatherMode;
    /**
     * 手续费
     */
    private Integer fee;
    /**
     * 法人证件号
     */
    private String idCard;
    /**
     * 纳税人编码
     */
    private String taxCode;
    /**
     * 结算账户信息
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private AccountInfo accountInfo;

    /**
     * 暂存账户信息
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private AccountInfo tempAccountInfo;
    /**
     * 商户信息
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private CommercialTenantInfo commercialTenantInfo;

    /**
     * 状态校验
     */
    public boolean checkStatus() {
        return status == ContractStatusEnum.VALID;
    }

}
