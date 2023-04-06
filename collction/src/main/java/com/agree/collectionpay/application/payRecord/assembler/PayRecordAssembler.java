package com.agree.collectionpay.application.payRecord.assembler;

import com.agree.collectionpay.application.payRecord.dto.PayRecordReqDto;
import com.agree.collectionpay.application.payRecord.dto.PayRecordResDto;
import com.agree.collectionpay.domain.payRecord.entity.PayRecord;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author xulingfeng
 * @date 2023/2
 */
@Mapper(componentModel = "spring")
public interface PayRecordAssembler {


    PayRecordResDto toDto(PayRecord payRecord);


    PayRecord toEntity(PayRecordReqDto dto);


    List<PayRecordResDto> toDto(List<PayRecord> dto);
}