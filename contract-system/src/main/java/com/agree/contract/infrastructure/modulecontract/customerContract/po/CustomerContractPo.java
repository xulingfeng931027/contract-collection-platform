package com.agree.contract.infrastructure.modulecontract.customerContract.po;

import com.agree.common.api.AbstractPo;
import com.agree.contract.domain.modulecontract.valueobject.AccountInfo;
import com.agree.contract.domain.modulecontract.valueobject.CustomerInfo;
import com.agree.contract.domain.modulecontract.valueobject.enumType.AgencyTypeEnum;
import com.agree.contract.domain.modulecontract.valueobject.enumType.ContractStatusEnum;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description 客户合约
 */
@Data
@TableName(value = "customer_contract", autoResultMap = true)
@SuperBuilder
public class CustomerContractPo extends AbstractPo<String> {
    /**
     * 申请单id
     */
    private String applicationFormId;
    /**
     * 合约状态
     */
    private ContractStatusEnum status;
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
