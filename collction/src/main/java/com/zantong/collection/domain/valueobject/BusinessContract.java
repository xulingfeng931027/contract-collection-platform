package com.zantong.collection.domain.valueobject;

import com.zantong.contract.domain.valueobject.ContractStatusEnum;
import com.zantong.contract.domain.valueobject.FundGatherModeEnum;
import lombok.Data;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description
 */
@Data
public class BusinessContract {
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
    private Integer fee;

    private String accountInfoId;

    private String tempAccountInfoId;

    /**
     * 状态校验
     */
    public boolean checkStatus() {
        return status == ContractStatusEnum.VALID;
    }

}
