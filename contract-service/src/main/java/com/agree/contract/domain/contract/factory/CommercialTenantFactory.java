package com.agree.contract.domain.contract.factory;

import com.agree.contract.domain.contract.commercialtenantcontract.entity.CommercialTenantContract;
import com.agree.contract.domain.contract.commercialtenantcontractapplicationform.entity.CommercialTenantContractApplicationForm;
import com.agree.contract.domain.contract.valueobject.enumType.ContractStatusEnum;

/**
 * @author xulingfeng
 * 
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
