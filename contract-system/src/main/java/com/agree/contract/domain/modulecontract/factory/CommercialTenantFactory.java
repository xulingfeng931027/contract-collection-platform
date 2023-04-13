package com.agree.contract.domain.modulecontract.factory;

import com.agree.contract.domain.modulecontract.commercialTenantContract.entity.CommercialTenantContract;
import com.agree.contract.domain.modulecontract.commercialTenantContractApplicationForm.entity.CommercialTenantContractApplicationForm;
import com.agree.contract.domain.modulecontract.valueobject.enumType.ContractStatusEnum;

/**
 * @author xulingfeng
 * @date 2023/3/24
 * @description 商户合约工厂类
 */
public class CommercialTenantFactory {
    /**
     * 生成商户合约
     *
     * @param applicationForm   合约申请单
     * @param applicationFormId 合约申请单id
     * @return 商户合约
     */
    public static CommercialTenantContract generateCommercialTenantContract(CommercialTenantContractApplicationForm applicationForm,
                                                                            String applicationFormId) {
        return CommercialTenantContract.builder()
                .contractApplicationFormId(applicationFormId)
                .status(ContractStatusEnum.VALID)
                .chargeType(applicationForm.getChargeType())
                .fundGatherMode(applicationForm.getFundGatherMode())
                .commissionCharge(applicationForm.getCommissionCharge())
                .settlementAccountInfo(applicationForm.getSettlementAccountInfo())
                .stagingAccountInfo(applicationForm.getStagingAccountInfo())
                .commercialTenantInfo(applicationForm.getCommercialTenantInfo())
                .build();
    }

}
