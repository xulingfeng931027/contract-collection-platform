package com.agree.collectionpay.domain.pay.valueobject;

import com.agree.collectionpay.domain.collection.valueobject.enumtypes.ChargeTypeEnum;
import com.agree.collectionpay.domain.collection.valueobject.enumtypes.FundGatherModeEnum;
import com.agree.collectionpay.domain.pay.exception.PayException;
import com.agree.common.ddd.obj.AbstractValueObject;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

/**
 * @author xulingfeng
 * 
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
            throw new PayException("商户合约状态不正常");
        }
    }
}
