package com.agree.contract.infrastructure.customerContract.po;

import com.agree.contract.domain.valueobject.*;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.Data;

import static com.baomidou.mybatisplus.annotation.IdType.ASSIGN_ID;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description 客户合约
 */
@Data
@TableName(value = "customer_contract", autoResultMap = true)
public class CustomerContractPo {
    /**
     * 合约id
     */
    @TableId(type = ASSIGN_ID)
    private String id;
    /**
     * 合约类型
     */
    private String type;
    /**
     * 合约状态
     */
    private ContractStatusEnum status;
    /**
     * 收费种类
     */
    private ChargeTypeEnum chargeType;

    /**
     * 签约模式 本行/他行卡
     */
    private AgencyTypeEnum agencyType;
    /**
     * 客户信息
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private CustomerInfo customerInfo;

    /**
     * 客户账户信息
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private AccountInfo customerAccountInfo;

    /**
     * 关联的商户合约id
     */
    private String commercialTenantContractId;

}
