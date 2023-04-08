package com.agree.collectionpay.domain.modulecollection.valueobject;

import com.agree.common.api.AbstractValueObject;
import com.agree.contract.domain.modulecontract.valueobject.ChargeTypeEnum;
import com.agree.contract.domain.modulecontract.valueobject.FundGatherModeEnum;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description 商户合约
 */
@Getter
@Builder
public class CommercialTenantContract extends AbstractValueObject {
    /**
     * 合约id
     */
    private String id;

    /**
     * 合约状态
     */
    private ContractStatusEnum status;
    /**
     * 手续费
     */
    private BigDecimal commissionCharge;
    /**
     * 收费种类
     */
    private ChargeTypeEnum chargeType;

    /**
     * 资金归集模式
     */
    private FundGatherModeEnum fundGatherMode;

    /**
     * 结算账户信息
     */
    private AccountInfo settlementAccountInfo;

    /**
     * 暂存账户信息
     */
    private AccountInfo stagingAccountInfo;

    /**
     * 校验商户合约状态是否正常
     */
    public void checkStatusIfNormal() {
        if (status != ContractStatusEnum.VALID) {
            throw new CommercialTenantContractException("商户合约状态不正常");
        }
    }
}
