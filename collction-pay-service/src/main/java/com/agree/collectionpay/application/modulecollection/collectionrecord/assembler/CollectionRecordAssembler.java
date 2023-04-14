package com.agree.collectionpay.application.collectionrecord.assembler;

import com.agree.collectionpay.application.collectionrecord.dto.ModifyCollectionRecordReqDto;
import com.agree.collectionpay.application.modulepay.payableInfo.dto.ExecutePayReqDto;
import com.agree.collectionpay.domain.modulecollection.collectionRecord.entity.CollectionRecord;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author xulingfeng
 * @description 计费记录转配器
 * 
 */
@Mapper
public interface CollectionRecordAssembler {

    CollectionRecordAssembler INSTANCE = Mappers.getMapper(CollectionRecordAssembler.class);

    CollectionRecord toEntity(ExecutePayReqDto dto);


    CollectionRecord toEntity(ModifyCollectionRecordReqDto dto);
}