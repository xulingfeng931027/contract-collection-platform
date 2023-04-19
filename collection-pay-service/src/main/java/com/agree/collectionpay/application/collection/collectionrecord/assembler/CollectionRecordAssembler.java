package com.agree.collectionpay.application.collection.collectionrecord.assembler;

import com.agree.collectionpay.application.collectionrecord.dto.ModifyCollectionRecordReqDto;
import com.agree.collectionpay.domain.collection.collectionRecord.entity.CollectionRecord;
import org.mapstruct.Mapper;

/**
 * @author xulingfeng
 * @description 计费记录转配器
 * 
 */
@Mapper(componentModel = "spring")
public interface CollectionRecordAssembler {


    CollectionRecord toEntity(ModifyCollectionRecordReqDto dto);
}