package com.agree.collectionpay.infrastructure.modulepay.payRecord.converter;

import com.agree.collectionpay.domain.modulepay.payRecord.entity.PayRecord;
import com.agree.collectionpay.infrastructure.modulepay.payRecord.po.PayRecordPo;
import org.mapstruct.Mapper;

/**
 * @author xulingfeng
 * @description 计费记录转配器
 * 
 */
@Mapper(componentModel = "spring")
public interface PayRecordConverter {


    PayRecord toEntity(PayRecordPo po);


    PayRecordPo toPo(PayRecord entity);
}