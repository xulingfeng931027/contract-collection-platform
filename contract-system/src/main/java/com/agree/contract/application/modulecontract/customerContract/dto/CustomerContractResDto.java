package com.agree.contract.application.modulecontract.customerContract.dto;

import com.agree.contract.domain.modulecontract.valueobject.AccountInfo;
import com.agree.contract.domain.modulecontract.valueobject.AgencyTypeEnum;
import com.agree.contract.domain.modulecontract.valueobject.ContractStatusEnum;
import com.agree.contract.domain.modulecontract.valueobject.CustomerInfo;
import lombok.Data;

/**
 * @author xulingfeng
 * @date 2023/3/17
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
     * 校验签约要素
     */
    public boolean checkSignElement() {
        return true;
    }
}
