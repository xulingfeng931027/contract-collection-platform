package com.agree.contract.domain.modulecontract.customercontract.entity;

import com.agree.common.api.AbstractAggregationObject;
import com.agree.common.exception.BaseException;
import com.agree.contract.domain.modulecontract.valueobject.AccountInfo;
import com.agree.contract.domain.modulecontract.valueobject.AgencyTypeEnum;
import com.agree.contract.domain.modulecontract.valueobject.ContractStatusEnum;
import com.agree.contract.domain.modulecontract.valueobject.CustomerInfo;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description 客户合约
 */
@Getter
@SuperBuilder
public class CustomerContract extends AbstractAggregationObject<String> {
    String id;

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
     * 关联的商户合约id
     */
    private String commercialTenantContractId;
    /**
     * 客户信息
     */
    private CustomerInfo customerInfo;

    /**
     * 客户账户信息
     */
    private AccountInfo customerAccountInfo;

    /**
     * 客户合约校验
     */
    public void checkStatusIfValid() {
        if (status != ContractStatusEnum.VALID) {
            throw new BaseException("合约状态不合法");
        }
    }

}
