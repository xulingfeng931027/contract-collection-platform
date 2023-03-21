package com.zantong.contract.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.zantong.contract.domain.entity.enumTypes.ContractStatuaEnum;
import com.zantong.contract.domain.entity.enumTypes.FundGatherModeEnum;
import com.zantong.contract.domain.entity.valueobject.AccountInfo;
import com.zantong.contract.domain.entity.valueobject.BusinessInfo;
import lombok.Data;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description
 */
@Data
@TableName(value = "business_contract", autoResultMap = true)
public class BusinessContractPo {
    /**
     * 合约id
     */
    @TableId
    private String id;
    /**
     * 合约名称
     */
    private String name;
    /**
     * 合约类型
     */
    private String type;
    /**
     * 合约状态
     */
    private ContractStatuaEnum status;
    /**
     * 收费种类
     */
    private String chargeType;

    /**
     * 项目代码
     */
    private String projectCode;

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
    private BusinessInfo businessInfo;

    /**
     * 状态校验
     */
    public boolean checkStatus() {
        return status == ContractStatuaEnum.VALID;
    }

}
