package com.agree.contract.domain.contract.commercialtenantcontract.entity;

import com.agree.common.ddd.exception.BaseException;
import com.agree.common.ddd.obj.AbstractAggregationObject;
import com.agree.contract.domain.contract.valueobject.AccountInfo;
import com.agree.contract.domain.contract.valueobject.CommercialTenantInfo;
import com.agree.contract.domain.contract.valueobject.enumType.ChargeMethodEnum;
import com.agree.contract.domain.contract.valueobject.enumType.ChargeTypeEnum;
import com.agree.contract.domain.contract.valueobject.enumType.ContractStatusEnum;
import com.agree.contract.domain.contract.valueobject.enumType.FundGatherModeEnum;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

/**
 * @author xulingfeng
 * 
 * @description 商户合约
 */


@Getter
@SuperBuilder
public class CommercialTenantContract extends AbstractAggregationObject<String> {
    /**
     * 合约申请单id
     */
    private String contractApplicationFormId;
    /**
     * 合约状态
     */
    private ContractStatusEnum status;
    /**
     * 收费种类
     */
    private ChargeTypeEnum chargeType;
    /**
     * 手续费
     */
    private BigDecimal commissionCharge;
    /**
     * 扣费方式
     */
    private ChargeMethodEnum chargeMethod;

    /**
     * 资金归集模式
     */
    private FundGatherModeEnum fundGatherMode;
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

    public void checkStatusIfValid() {
        if (status != ContractStatusEnum.VALID) {
            throw new BaseException("商户合约状态无效");
        }
    }

}
