package com.agree.contract.infrastructure.contract.commercialTenantcontractapplicationform.converter;

import com.agree.contract.domain.contract.commercialtenantcontractapplicationform.entity.CommercialTenantContractApplicationForm;
import com.agree.contract.infrastructure.contract.commercialTenantcontractapplicationform.po.CommercialTenantContractApplicationFormPo;
import org.mapstruct.Mapper;

/**
 * @author xulingfeng
 * @description 商户合约申请单转换器
 */
@Mapper(componentModel = "spring")
public interface CommercialTenantContractApplicationFormConverter {
    /**
     * 将商户合约申请单实体转换为po
     */
    CommercialTenantContractApplicationFormPo toPo(CommercialTenantContractApplicationForm applicationForm);

    /**
     * 将商户合约申请单po转换为实体
     */

    CommercialTenantContractApplicationForm toEntity(CommercialTenantContractApplicationFormPo applicationFormPo);
}
