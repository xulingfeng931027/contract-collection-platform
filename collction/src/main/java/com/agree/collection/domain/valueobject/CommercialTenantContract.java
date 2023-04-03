package com.agree.collection.domain.valueobject;

import com.agree.common.api.AbstractValueObject;
import com.agree.contract.domain.valueobject.ChargeTypeEnum;
import com.agree.contract.domain.valueobject.ContractStatusEnum;
import com.agree.contract.domain.valueobject.FundGatherModeEnum;
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

}
