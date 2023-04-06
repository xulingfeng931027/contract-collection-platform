package com.agree.contract.domain.customercontract.entity;

import com.agree.common.api.AbstractIdObject;
import com.agree.contract.domain.valueobject.AccountInfo;
import com.agree.contract.domain.valueobject.AgencyTypeEnum;
import com.agree.contract.domain.valueobject.ContractStatusEnum;
import com.agree.contract.domain.valueobject.CustomerInfo;
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
     * 申请单id
     */
    private String applicationFormId;
    /**
     * 合约状态
     */
    private ContractStatusEnum status;

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
     * 关联的商户合约id
     */
    private String commercialTenantContractId;

    /**
     * 客户合约校验
     */
    public boolean statusIsValid() {
        return status == ContractStatusEnum.VALID;
    }

}
