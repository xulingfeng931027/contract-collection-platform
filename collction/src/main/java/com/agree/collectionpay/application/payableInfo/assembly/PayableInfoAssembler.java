package com.agree.collectionpay.application.payableInfo.assembly;

import com.agree.collectionpay.application.payableInfo.dto.PayableInfoReqDto;
import com.agree.collectionpay.application.payableInfo.dto.PayableInfoResDto;
import com.agree.collectionpay.domain.payableInfo.entity.PayableInfo;
import org.mapstruct.Mapper;

/**
 * @author xulingfeng
 * @description 计费记录转配器
 * @date 2023/2
 */
@Mapper(componentModel = "spring")
public interface PayableInfoAssembler {


    PayableInfo toEntity(PayableInfoReqDto dto);


    PayableInfoResDto toDto(PayableInfo entity);
}