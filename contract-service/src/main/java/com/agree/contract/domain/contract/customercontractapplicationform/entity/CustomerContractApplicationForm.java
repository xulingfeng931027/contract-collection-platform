package com.agree.contract.domain.contract.customercontractapplicationform.entity;

import com.agree.common.ddd.obj.AbstractAggregationObject;
import com.agree.contract.domain.contract.valueobject.AccountInfo;
import com.agree.contract.domain.contract.valueobject.CustomerInfo;
import com.agree.contract.domain.contract.valueobject.enumType.ContractApplicationFormStatusEnum;
import com.agree.contract.domain.contract.valueobject.enumType.SigningMode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @author xulingfeng
 * 
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
    private SigningMode signingMode;
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
