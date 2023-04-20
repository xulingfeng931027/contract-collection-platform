package com.agree.contract.application.contract.customercontract.dto;

import com.agree.contract.domain.contract.valueobject.AccountInfo;
import com.agree.contract.domain.contract.valueobject.CustomerInfo;
import com.agree.contract.domain.contract.valueobject.enumType.ContractStatusEnum;
import com.agree.contract.domain.contract.valueobject.enumType.SigningMode;
import lombok.Data;

/**
 * @author xulingfeng
 * 
 * @description
 */
@Data
public class CustomerContractResDto {

    private String id;
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
     * 校验签约要素
     */
    public boolean checkSignElement() {
        return true;
    }
}
