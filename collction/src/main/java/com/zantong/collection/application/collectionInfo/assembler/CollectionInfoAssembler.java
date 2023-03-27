package com.zantong.collection.application.collectionInfo.assembler;

import com.zantong.collection.application.collectionInfo.dto.CollectionInfoDto;
import com.zantong.collection.application.collectionInfo.dto.ExecuteCollectionReqDto;
import com.zantong.collection.domain.collectionInfo.entity.CollectionInfo;
import com.zantong.collection.domain.collectionRecord.entity.CollectionRecord;
import org.mapstruct.Mapper;

/**
 * @author xulingfeng
 * @description 代收信息
 * @date 2023/2
 */
@Mapper(componentModel = "spring")
public interface CollectionInfoAssembler {


    CollectionInfo toEntity(CollectionInfoDto dto);


    CollectionRecord toEntity(ExecuteCollectionReqDto dto);


}