package com.agree.collection.application.payRecord.assembler;

import com.agree.collection.application.payRecord.dto.PayRecordReqDto;
import com.agree.collection.application.payRecord.dto.PayRecordResDto;
import com.agree.pay.domain.payRecord.entity.PayRecord;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author xulingfeng
 * @date 2023/2
 */
@Mapper(componentModel = "spring")
public interface PayRecordAssembler {


    PayRecordResDto toResDto(PayRecord payRecord);


    PayRecord toEntity(PayRecordReqDto dto);

    PayRecordReqDto toReqDto(PayRecord dto);


    List<PayRecordResDto> toDto(List<PayRecord> dto);
}