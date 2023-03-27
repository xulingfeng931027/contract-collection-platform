package com.zantong.pay.application.payableInfo.assembly;

import com.zantong.pay.application.payRecord.dto.PayRecordResDto;
import com.zantong.pay.application.payRecord.dto.PayableInfoDto;
import com.zantong.pay.domain.payRecord.entity.PayRecord;
import com.zantong.pay.domain.payableInfo.entity.PayableInfo;
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