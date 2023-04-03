package com.agree.collection.application.collectionrecord.assembler;

import com.agree.collection.application.collectionInfo.dto.ExecuteCollectionReqDto;
import com.agree.collection.application.collectionrecord.dto.ModifyCollectionRecordReqDto;
import com.agree.collection.domain.collectionRecord.entity.CollectionRecord;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author xulingfeng
 * @description 计费记录转配器
 * @date 2023/2
 */
@Mapper
public interface CollectionRecordAssembler {

    CollectionRecordAssembler INSTANCE = Mappers.getMapper(CollectionRecordAssembler.class);

    CollectionRecord toEntity(ExecuteCollectionReqDto dto);


    CollectionRecord toEntity(ModifyCollectionRecordReqDto dto);
}