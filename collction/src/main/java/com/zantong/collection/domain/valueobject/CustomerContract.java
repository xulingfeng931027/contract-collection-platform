package com.zantong.collection.domain.valueobject;

import com.zantong.contract.domain.valueobject.AgencyTypeEnum;
import com.zantong.contract.domain.valueobject.ContractStatusEnum;
import lombok.Data;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description 客户合约
 */
@Data
public class CustomerContract{
    /**
     * 合约id
     */
    private String id;
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
    private String chargeType;

    /**
     * 签约模式 本行/他行卡
     */
    private AgencyTypeEnum agencyType;;

    /**
     * 用户编号
     */
    private String customerCode;

    /**
     * 关联的商户合约id
     */
    private String businessContractId;
    /**
     * 关联的商户合约id
     */
    private String accountInfoId;
    /**
     * 状态校验
     */
    public boolean checkStatus() {
        return status == ContractStatusEnum.VALID;
    }

}
