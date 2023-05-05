package com.agree.contract.infrastructure.contract.customerContract.po;

import com.agree.common.ddd.obj.AbstractPo;
import com.agree.contract.domain.contract.valueobject.enumType.ContractStatusEnum;
import com.agree.contract.domain.contract.valueobject.enumType.SigningMode;
import com.agree.contract.infrastructure.contract.commercialTenantcontractapplicationform.po.AccountInfoPo;
import com.agree.contract.infrastructure.contract.customerContractApplicationForm.po.CustomerInfoPo;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * @author xulingfeng
 * 
 * @description 客户合约
 */
@Data
@TableName("customer_contract")
@SuperBuilder
public class CustomerContractPo extends AbstractPo<String> {
    /**
     * 客户合约申请单ID
     */
    private String applicationFormId;

    /**
     * 合约状态
     */
    private ContractStatusEnum status;

    /**
     * 签约模式 本行/他行卡
     */
    private SigningMode signingMode;

    /**
     * 客户账户信息
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private AccountInfoPo customerAccountInfo;

    /**
     * 客户信息
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private CustomerInfoPo CustomerInfo;

    /**
     * 商户合约ID
     */
    private String commercialTenantContractId;

}
