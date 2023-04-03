package com.agree.collection.application.collectionInfo.assembler;

import com.agree.collection.application.collectionInfo.dto.CollectionInfoDto;
import com.agree.collection.application.collectionInfo.dto.ExecuteCollectionReqDto;
import com.agree.collection.domain.collectionInfo.entity.CollectionInfo;
import com.agree.collection.domain.collectionRecord.entity.CollectionRecord;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author xulingfeng
 * @description 代收信息
 * @date 2023/2
 */
@Mapper(componentModel = "spring")
public interface CollectionInfoAssembler {


    CollectionInfo toEntity(CollectionInfoDto dto);
    List<CollectionInfo> toEntity(List<CollectionInfoDto> dtos);

    CollectionRecord toEntity(ExecuteCollectionReqDto dto);


}