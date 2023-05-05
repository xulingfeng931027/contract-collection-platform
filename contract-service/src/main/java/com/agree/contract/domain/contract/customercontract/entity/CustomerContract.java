package com.agree.contract.domain.contract.customercontract.entity;

import com.agree.common.ddd.obj.AbstractAggregationObject;
import com.agree.contract.domain.contract.exception.ContractException;
import com.agree.contract.domain.contract.valueobject.AccountInfo;
import com.agree.contract.domain.contract.valueobject.CustomerInfo;
import com.agree.contract.domain.contract.valueobject.enumType.ContractStatusEnum;
import com.agree.contract.domain.contract.valueobject.enumType.SigningMode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import static com.agree.contract.domain.contract.exception.ContractErrorCode.CUSTOMER_CONTRACT_STATUS_INVALID;

/**
 * @author xulingfeng
 * 
 * @description 客户合约
 */
@Getter
@SuperBuilder
public class CustomerContract extends AbstractAggregationObject<String> {

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

    /**
     * 客户合约校验
     */
    public void checkStatusIfValid() {
        if (status != ContractStatusEnum.VALID) {
            throw new ContractException(CUSTOMER_CONTRACT_STATUS_INVALID);
        }
    }

}
