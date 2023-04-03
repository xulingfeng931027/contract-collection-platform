package com.agree.collection.domain.valueobject;

import com.agree.contract.domain.valueobject.ContractStatusEnum;
import com.agree.contract.domain.valueobject.FundGatherModeEnum;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description
 */
@Data
public class CommercialTenantContract {
    /**
     * 合约id
     */
    private String id;
    /**
     * 合约名称
     */
    private String name;
    /**
     * 合约状态
     */
    private ContractStatusEnum status;
    /**
     * 收费种类
     */
    private String chargeType;
    /**
     * 资金归集模式
     */
    private FundGatherModeEnum fundGatherMode;
    /**
     * 手续费
     */
    private BigDecimal commissionCharge;

    private String accountInfoId;

    private String tempAccountInfoId;

    /**
     * 状态校验
     */
    public boolean checkStatus() {
        return status == ContractStatusEnum.VALID;
    }

}
