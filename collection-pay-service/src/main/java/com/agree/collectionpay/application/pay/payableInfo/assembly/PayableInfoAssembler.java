package com.agree.collectionpay.application.pay.payableInfo.assembly;

import com.agree.collectionpay.application.pay.payableInfo.dto.PayableInfoReqDto;
import com.agree.collectionpay.application.pay.payableInfo.dto.PayableInfoResDto;
import com.agree.collectionpay.domain.pay.payableinfo.entity.PayableInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author xulingfeng
 * @description 计费记录转配器
 * 
 */
@Mapper(componentModel = "spring")
public interface PayableInfoAssembler {


    @Mapping(source = "dto.customerAccountInfoId",target = "customerAccountInfo.id")
    @Mapping(source = "dto.commercialTenantContractId",target = "commercialTenantContract.id")
    PayableInfo toEntity(PayableInfoReqDto dto);


    PayableInfoResDto toDto(PayableInfo entity);
}