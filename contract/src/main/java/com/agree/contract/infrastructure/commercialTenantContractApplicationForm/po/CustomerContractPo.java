package com.agree.contract.infrastructure.commercialTenantContractApplicationForm.po;

import com.agree.contract.domain.valueobject.AgencyTypeEnum;
import com.agree.contract.domain.valueobject.ContractStatusEnum;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description 客户合约
 */
@Data
@TableName("customer_contract")
public class CustomerContractPo {
    /**
     * 合约id
     */
    @TableId
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
    private AgencyTypeEnum agencyType;
    /**
     * 客户信息
     */
    private String customerInfo;

    /**
     * 客户账户信息
     */
    private String customerAccountInfo;

    /**
     * 用户编号
     */
    private String customerCode;

    /**
     * 关联的商户合约id
     */
    private String customerContractId;
    /**
     * 状态校验
     */
    public boolean checkStatus() {
        return status == ContractStatusEnum.VALID;
    }

}
