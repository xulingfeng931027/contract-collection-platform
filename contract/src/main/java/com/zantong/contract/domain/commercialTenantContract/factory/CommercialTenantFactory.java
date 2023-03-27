package com.zantong.contract.domain.commercialTenantContract.factory;

import com.zantong.contract.domain.commercialTenantContract.entity.CommercialTenantContract;
import com.zantong.contract.domain.commercialTenantContractApplicationForm.entity.CommercialTenantContractApplicationForm;
import com.zantong.contract.domain.valueobject.ContractStatusEnum;

/**
 * @author xulingfeng
 * @date 2023/3/24
 * @description 商户合约工厂类
 */
public class CommercialTenantFactory {

    public static CommercialTenantContract convertToCommercialTenantContract(CommercialTenantContractApplicationForm commercialTenantContractApplicationForm, String id) {
        return CommercialTenantContract.builder()
                .contractApplicationFormId(id)
                .name(commercialTenantContractApplicationForm.getName())
                .status(ContractStatusEnum.VALID)
                .chargeType(commercialTenantContractApplicationForm.getChargeType())
                .fundGatherMode(commercialTenantContractApplicationForm.getFundGatherMode())
                .commissionCharge(commercialTenantContractApplicationForm.getCommissionCharge())
                .settlementAccountInfo(commercialTenantContractApplicationForm.getSettlementAccountInfo())
                .stagingAccountInfo(commercialTenantContractApplicationForm.getStagingAccountInfo())
                .commercialTenantInfo(commercialTenantContractApplicationForm.getCommercialTenantInfo())
                .build();
    }

}
