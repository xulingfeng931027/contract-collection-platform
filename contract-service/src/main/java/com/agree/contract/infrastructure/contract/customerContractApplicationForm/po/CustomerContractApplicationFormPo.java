package com.agree.contract.infrastructure.contract.customerContractApplicationForm.po;

import com.agree.common.ddd.obj.AbstractPo;
import com.agree.contract.domain.contract.valueobject.enumType.AgencyTypeEnum;
import com.agree.contract.domain.contract.valueobject.enumType.ContractApplicationFormStatusEnum;
import com.agree.contract.infrastructure.contract.commercialTenantcontractapplicationform.po.AccountInfoPo;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * @author xulingfeng
 * 
 * @description
 */
@Data
@TableName(value = "customer_contract_application_form", autoResultMap = true)
@SuperBuilder
public class CustomerContractApplicationFormPo extends AbstractPo<String> {
    /**
     * 合约申请单状态
     */
    private ContractApplicationFormStatusEnum status;
    /**
     * 签约模式
     */
    private AgencyTypeEnum agencyTypeEnum;
    /**
     * 客户账户信息
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private AccountInfoPo customerAccountInfo;

    /**
     * 客户信息
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private CustomerInfoPo customerInfo;

    /**
     * 商户合约id
     */
    private String commercialTenantContractId;

}
