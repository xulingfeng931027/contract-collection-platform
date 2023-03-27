package com.zantong.contract.infrastructure.customerContractApplicationForm.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.zantong.common.api.AbstractPo;
import com.zantong.contract.domain.commercialTenantContract.entity.CommercialTenantContract;
import com.zantong.contract.domain.valueobject.AccountInfo;
import com.zantong.contract.domain.valueobject.AgencyTypeEnum;
import com.zantong.contract.domain.valueobject.ChargeTypeEnum;
import com.zantong.contract.domain.valueobject.ContractApplicationFormStatusEnum;
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
     * 合约名称
     */
    private String name;

    /**
     * 合约申请单状态
     */
    private ContractApplicationFormStatusEnum status;
    /**
     * 收费种类  todo 具有明显的业务意义，应该用枚举
     */
    private ChargeTypeEnum chargeType;
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
     * 商户合约
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)

    private CommercialTenantContract commercialTenantContract;

}