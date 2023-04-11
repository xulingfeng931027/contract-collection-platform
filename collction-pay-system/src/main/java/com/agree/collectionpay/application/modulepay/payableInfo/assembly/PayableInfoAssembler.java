package com.agree.collectionpay.application.modulepay.payableInfo.assembly;

import com.agree.collectionpay.application.modulepay.payableInfo.dto.PayableInfoReqDto;
import com.agree.collectionpay.application.modulepay.payableInfo.dto.PayableInfoResDto;
import com.agree.collectionpay.domain.modulepay.payableinfo.entity.PayableInfo;
import org.mapstruct.Mapper;

/**
 * @author xulingfeng
 * @description 计费记录转配器
 * @date 2023/3/11
 */
@Mapper(componentModel = "spring")
public interface PayableInfoAssembler {


    PayableInfo toEntity(PayableInfoReqDto dto);


    PayableInfoResDto toDto(PayableInfo entity);
}