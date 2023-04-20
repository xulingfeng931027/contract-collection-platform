package com.agree.collectionpay.application.collectionInfo.assembler;

import com.agree.collectionpay.application.collection.collectionInfo.dto.CollectionInfoDto;
import com.agree.collectionpay.domain.collection.collectionInfo.entity.CollectionInfo;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author xulingfeng
 * @description 代收信息
 * 
 */
@Mapper(componentModel = "spring")
public interface CollectionInfoAssembler {


    CollectionInfo toEntity(CollectionInfoDto dto);
    List<CollectionInfo> toEntity(List<CollectionInfoDto> dtos);


}