package com.zantong.contract.domain.customercontract;

import com.zantong.common.api.AbstractIdObject;
import com.zantong.contract.domain.valueobject.*;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description 客户合约
 */
@Getter
@SuperBuilder
public class CustomerContract extends AbstractIdObject<String> {
    /**
     * 合约名称
     */
    private String name;
    /**
     * 合约类型
     */
    private String type;
    /**
     * 合约状态
     */
    private ContractStatusEnum status;
    /**
     * 收费种类
     */
    private ChargeTypeEnum chargeType;

    /**
     * 签约模式 本行/他行卡
     */
    private AgencyTypeEnum agencyType;
    /**
     * 客户信息
     */
    private CustomerInfo customerInfo;

    /**
     * 客户账户信息
     */
    private AccountInfo customerAccountInfo;

    /**
     * 用户编号
     */
    private String customerCode;

    /**
     * 关联的商户合约id
     */
    private String commercialTenantContractId;
    /**
     * 状态校验
     */
    public boolean checkStatus() {
        return status == ContractStatusEnum.VALID;
    }

}
