package com.agree.collectionpay.application.pay.payableInfo.assembly;

import com.agree.collectionpay.application.pay.payableInfo.dto.PayableInfoReqDto;
import com.agree.collectionpay.application.pay.payableInfo.dto.PayableInfoResDto;
import com.agree.collectionpay.domain.pay.payableinfo.entity.PayableInfo;
import org.mapstruct.Mapper;

/**
 * @author xulingfeng
 * @description 计费记录转配器
 * 
 */
@Mapper(componentModel = "spring")
public interface PayableInfoAssembler {


    PayableInfo toEntity(PayableInfoReqDto dto);


    PayableInfoResDto toDto(PayableInfo entity);
}