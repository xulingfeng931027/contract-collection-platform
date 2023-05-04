package com.agree.contract.domain.contract.commercialtenantcontractapplicationform.entity;

import com.agree.common.ddd.obj.AbstractAggregationObject;
import com.agree.contract.domain.contract.valueobject.AccountInfo;
import com.agree.contract.domain.contract.valueobject.CommercialTenantInfo;
import com.agree.contract.domain.contract.valueobject.enumType.ChargeMethodEnum;
import com.agree.contract.domain.contract.valueobject.enumType.ChargeTypeEnum;
import com.agree.contract.domain.contract.valueobject.enumType.ContractApplicationFormStatusEnum;
import com.agree.contract.domain.contract.valueobject.enumType.FundGatherModeEnum;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * @author xulingfeng
 * @description 商户合约申请单
 */

@Getter
@SuperBuilder
public class CommercialTenantContractApplicationForm extends AbstractAggregationObject<String> {

    /**
     * 合约申请单状态
     */
    private ContractApplicationFormStatusEnum status;
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
     * 扣费方式
     */
    private ChargeMethodEnum chargeMethod;
    /**
     * 商户信息
     */
    private CommercialTenantInfo commercialTenantInfo;
    /**
     * 结算账户信息
     */
    private AccountInfo settlementAccountInfo;

    /**
     * 暂存账户信息
     */
    private AccountInfo stagingAccountInfo;

    /**
     * 校验商户合约申请单
     */
    public void checkIfValid() {
        checkChargeTypeIfValid();
        checkChargeMethodIfValid();
    }

    /**
     * 校验扣费方式是否合法
     */
    private void checkChargeMethodIfValid() {
    }

    /**
     * 校验收费种类是否合法
     */
    private void checkChargeTypeIfValid() {
    }


    /**
     * 填充商户信息到实体
     *
     * @param commercialTenantInfo
     */
    public void completeCommercialTenantInfo(CommercialTenantInfo commercialTenantInfo) {
        this.commercialTenantInfo = commercialTenantInfo;
    }

    /**
     * 判定是否是归总归集方式
     */
    public boolean fundGatherModeIsSum() {
        return fundGatherMode == FundGatherModeEnum.SUM;
    }
}
