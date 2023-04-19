package com.agree.collectionpay.application.pay.payRecord.assembler;

import com.agree.collectionpay.application.pay.payRecord.dto.PayRecordReqDto;
import com.agree.collectionpay.application.pay.payRecord.dto.PayRecordResDto;
import com.agree.collectionpay.domain.pay.payRecord.entity.PayRecord;
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