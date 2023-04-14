package com.agree.collectionpay.application.collectionInfo.assembler;

import com.agree.collectionpay.application.collectionInfo.dto.CollectionInfoDto;
import com.agree.collectionpay.application.pay.payableInfo.dto.ExecutePayReqDto;
import com.agree.collectionpay.domain.collection.collectionInfo.entity.CollectionInfo;
import com.agree.collectionpay.domain.collection.collectionRecord.entity.CollectionRecord;
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

    CollectionRecord toEntity(ExecutePayReqDto dto);


}