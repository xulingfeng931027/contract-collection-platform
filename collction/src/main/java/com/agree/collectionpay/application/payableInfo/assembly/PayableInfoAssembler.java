package com.agree.collectionpay.application.payableInfo.assembly;

import com.agree.collectionpay.application.payRecord.dto.PayRecordResDto;
import com.agree.collectionpay.application.payRecord.dto.PayableInfoDto;
import com.agree.collectionpay.domain.payRecord.entity.PayRecord;
import com.agree.collectionpay.domain.payableInfo.entity.PayableInfo;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author xulingfeng
 * @description 计费记录转配器
 * @date 2023/2
 */
@Mapper(componentModel = "spring")
public interface PayableInfoAssembler {


    PayableInfo toEntity(PayableInfoDto dto);


    List<PayRecordResDto> toDto(List<PayRecord> dto);
}