package com.zantong.collection.application.assembly;

import com.zantong.collection.application.dto.CollectionInfoDto;
import com.zantong.collection.application.dto.CollectionParamDto;
import com.zantong.collection.domain.collectionInfoAggregation.entity.CollectionInfo;
import com.zantong.collection.domain.collectionInfoAggregation.valueobject.BusinessContract;
import com.zantong.collection.domain.collectionInfoAggregation.valueobject.CustomerContract;
import com.zantong.collection.domain.collectionRecordAggregation.entity.CollectionRecord;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xulingfeng
 * @description 计费记录转配器
 * @date 2023/2
 */
@Mapper
public interface CollectionRecordAssembler {

    CollectionRecordAssembler INSTANCE = Mappers.getMapper(CollectionRecordAssembler.class);

    CollectionInfo toEntity(CollectionInfoDto dto);

    CollectionRecord toEntity(CollectionParamDto dto);

    default CollectionRecord toRecord(BusinessContract businessContract, CustomerContract customerContract, BigDecimal amount) {
        CollectionRecord record = new CollectionRecord();
        record.setAmount(amount);
        record.setCustomerContractId(customerContract.getId());
        record.setBusinessContractId(customerContract.getBusinessContractId());
        record.setCustomerAccountInfoId(customerContract.getAccountInfoId());
        record.setBusinessAccountInfoId(businessContract.getAccountInfoId());
        record.setCreateTime(new Date());
        return record;
    }


}