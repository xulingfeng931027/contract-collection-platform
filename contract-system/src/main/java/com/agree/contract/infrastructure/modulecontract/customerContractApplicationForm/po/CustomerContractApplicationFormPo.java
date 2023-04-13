package com.agree.contract.infrastructure.modulecontract.customerContractApplicationForm.po;

import com.agree.common.api.AbstractPo;
import com.agree.contract.domain.modulecontract.valueobject.AccountInfo;
import com.agree.contract.domain.modulecontract.valueobject.CustomerInfo;
import com.agree.contract.domain.modulecontract.valueobject.enumType.AgencyTypeEnum;
import com.agree.contract.domain.modulecontract.valueobject.enumType.ContractApplicationFormStatusEnum;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * @author xulingfeng
 * @date 2023/3/17
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
//    /**
//     * 收费种类
//     */
//    private ChargeTypeEnum chargeType;
    /**
     * 签约模式
     */
    private AgencyTypeEnum agencyTypeEnum;
    /**
     * 客户账户信息
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private AccountInfo customerAccountInfo;

    /**
     * 客户信息
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private CustomerInfo customerInfo;

    /**
     * 商户合约id
     */
    private String commercialTenantContractId;

}
