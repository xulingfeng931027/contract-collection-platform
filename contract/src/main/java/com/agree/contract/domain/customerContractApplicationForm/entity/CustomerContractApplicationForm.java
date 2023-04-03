package com.agree.contract.domain.customerContractApplicationForm.entity;

import com.agree.common.api.AbstractIdObject;
import com.agree.contract.domain.commercialTenantContract.entity.CommercialTenantContract;
import com.agree.contract.domain.valueobject.*;
import lombok.Builder;
import lombok.Getter;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description 客户合约申请单
 */

@Getter
@Builder
public class CustomerContractApplicationForm extends AbstractIdObject<String> {
    /**
     * 合约申请单状态
     */
    private ContractApplicationFormStatusEnum status;
    /**
     * 收费种类
     */
    private ChargeTypeEnum chargeType;
    /**
     * 签约模式
     */
    private AgencyTypeEnum agencyTypeEnum;
    /**
     * 客户账户信息
     */
    private AccountInfo customerAccountInfo;

    /**
     * 商户合约
     */
    private CommercialTenantContract commercialTenantContract;
    /**
     * 客户信息
     */
    private CustomerInfo customerInfo;


    /**
     * 校验商户合约申请单
     */
    public void checkIfValid() {
        checkCommissionChargeIfValid();
        checkChargeTypeIfValid();
    }

    /**
     * 校验商户合约收费类型
     */
    private void checkChargeTypeIfValid() {
    }

    /**
     * 校验商户合约手续费
     */
    private void checkCommissionChargeIfValid() {
        // todo 校验逻辑
    }
}
