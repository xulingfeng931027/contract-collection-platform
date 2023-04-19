package com.agree.collectionpay.infrastructure.collection.collectionrecord.converter;

import com.agree.collectionpay.domain.collection.collectionRecord.entity.CollectionRecord;
import com.agree.collectionpay.infrastructure.collection.collectionrecord.po.CollectionRecordPo;
import org.mapstruct.Mapper;

/**
 * @author xulingfeng
 * 
 * @description
 */
@Mapper(componentModel = "spring")
public interface CollectionRecordConverter {

    CollectionRecordPo toPo(CollectionRecord record);


    CollectionRecord toEntity(CollectionRecordPo po);
}
