package com.agree.contract.application.CommercialTenantContract.dto;

import com.agree.contract.domain.valueobject.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description 商户合约dto
 */
@Data
public class CommercialTenantContractResDto {

    /**
     * 合约id
     */
    private String id;
    /**
     * 合约申请单id
     */
    private String contractApplicationFormId;
    /**
     * 合约状态
     */
    private ContractStatusEnum status;
    /**
     * 收费种类
     */
    private ChargeTypeEnum chargeType;

    /**
     * 资金归集模式
     */
    private FundGatherModeEnum fundGatherMode;
    /**
     * 手续费
     */
    private BigDecimal commissionCharge;
    /**
     * 结算账户信息
     */
    private AccountInfo settlementAccountInfo;

    /**
     * 暂存账户信息
     */
    private AccountInfo stagingAccountInfo;
    /**
     * 商户信息
     */
    private CommercialTenantInfo commercialTenantInfo;

}
