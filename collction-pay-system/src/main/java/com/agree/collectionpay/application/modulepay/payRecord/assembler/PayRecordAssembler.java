package com.agree.collectionpay.application.modulepay.payRecord.assembler;

import com.agree.collectionpay.application.modulepay.payRecord.dto.PayRecordReqDto;
import com.agree.collectionpay.application.modulepay.payRecord.dto.PayRecordResDto;
import com.agree.collectionpay.domain.modulepay.payRecord.entity.PayRecord;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author xulingfeng
 * 
 */
@Mapper(componentModel = "spring")
public interface PayRecordAssembler {


    PayRecordResDto toDto(PayRecord payRecord);


    PayRecord toEntity(PayRecordReqDto dto);


    List<PayRecordResDto> toDto(List<PayRecord> dto);
}