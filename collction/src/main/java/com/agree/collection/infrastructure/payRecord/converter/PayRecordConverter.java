package com.agree.collection.infrastructure.payRecord.converter;

import com.agree.collection.domain.payRecord.entity.PayRecord;
import com.agree.collection.infrastructure.payRecord.po.PayRecordPo;
import org.mapstruct.Mapper;

/**
 * @author xulingfeng
 * @description 计费记录转配器
 * @date 2023/2
 */
@Mapper(componentModel = "spring")
public interface PayRecordConverter {


    PayRecord toEntity(PayRecordPo po);


    PayRecordPo toPo(PayRecord entity);
}