package com.agree.contract.infrastructure.contract.commercialtenantcontract.converter;

import com.agree.contract.domain.contract.commercialtenantcontract.entity.CommercialTenantContract;
import com.agree.contract.infrastructure.contract.commercialtenantcontract.po.CommercialTenantContractPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author xulingfeng
 * @description 商户合约转换器
 */
@Mapper(componentModel = "spring")
public interface CommercialTenantContractConverter {
    /**
     * 将商户合约实体转换为po
     */
    @Mapping(source = "commercialTenantContract.commercialTenantInfo.legalPersonNumber", target = "legalPersonNumber")
    CommercialTenantContractPo toPo(CommercialTenantContract commercialTenantContract);

    /**
     * 将商户合约po转换为实体
     */
    CommercialTenantContract toEntity(CommercialTenantContractPo commercialTenantContractPo);
}
