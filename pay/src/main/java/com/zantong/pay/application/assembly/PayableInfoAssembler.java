package com.zantong.pay.application.assembly;

import com.alibaba.fastjson2.JSONObject;
import com.zantong.pay.application.dto.PayRecordDto;
import com.zantong.pay.application.dto.PayableInfoDto;
import com.zantong.pay.domain.payRecordAggregation.entity.PayRecord;
import com.zantong.pay.domain.payableInfoAggregation.entity.PayableInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author xulingfeng
 * @description 计费记录转配器
 * @date 2023/2
 */
@Mapper
public interface PayableInfoAssembler {

    PayableInfoAssembler INSTANCE = Mappers.getMapper(PayableInfoAssembler.class);

    PayableInfoDto toDto(PayableInfo dto);

    default PayRecord toEntity(PayableInfoDto dto, JSONObject result) {
        PayRecord payRecord = new PayRecord();
        payRecord.setAmount(dto.getAmount());
        payRecord.setResult(result.getInteger("result"));
        payRecord.setPayInfoCode(dto.getPayInfoCode());
        payRecord.setUserCode(dto.getUserCode());
        payRecord.setBusinessContract(dto.getBusinessContract());
        payRecord.setCustomerAccountInfo(dto.getCustomerAccountInfo());
        return payRecord;
    }

    PayRecord toEntity(PayRecordDto dto);

    PayRecordDto toDto(PayRecord dto);


    List<PayRecordDto> toDto(List<PayRecord> dto);
}