package com.agree.collection.infrastructure.collectionrecord.converter;

import com.agree.collection.domain.collectionRecord.entity.CollectionRecord;
import com.agree.collection.infrastructure.collectionrecord.po.CollectionRecordPo;
import org.mapstruct.Mapper;

/**
 * @author xulingfeng
 * @date 2023/3/20
 * @description
 */
@Mapper(componentModel = "spring")
public interface CollectionRecordConverter {

    CollectionRecordPo toPo(CollectionRecord record);


    CollectionRecord toEntity(CollectionRecordPo po);
}
