package com.agree.contract.domain.modulecontract.customerContractApplicationForm.entity;

import com.agree.common.api.AbstractAggregationObject;
import com.agree.contract.domain.modulecontract.valueobject.AccountInfo;
import com.agree.contract.domain.modulecontract.valueobject.CustomerInfo;
import com.agree.contract.domain.modulecontract.valueobject.enumType.AgencyTypeEnum;
import com.agree.contract.domain.modulecontract.valueobject.enumType.ContractApplicationFormStatusEnum;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description 客户合约申请单
 */

@Getter
@SuperBuilder
public class CustomerContractApplicationForm extends AbstractAggregationObject<String> {
    String id;
    /**
     * 合约申请单状态
     */
    private ContractApplicationFormStatusEnum status;
    /**
     * 签约模式
     */
    private AgencyTypeEnum agencyTypeEnum;
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

}
