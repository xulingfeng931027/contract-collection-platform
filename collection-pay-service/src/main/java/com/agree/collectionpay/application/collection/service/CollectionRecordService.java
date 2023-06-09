package com.agree.collectionpay.application.collection.collectionrecord.service;

import com.agree.collectionpay.application.collection.collectionrecord.assembler.CollectionRecordAssembler;
import com.agree.collectionpay.application.collectionrecord.dto.ModifyCollectionRecordReqDto;
import com.agree.collectionpay.domain.collection.collectionRecord.entity.CollectionRecord;
import com.agree.collectionpay.domain.collection.collectionRecord.repository.CollectionRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * @author xulingfeng
 * @description 代收记录服务
 * 
 */
@Service
public class CollectionRecordService {

    @Autowired
    private CollectionRecordRepository collectionRecordRepository;
    @Autowired
    private CollectionRecordAssembler collectionRecordAssembler;

    /**
     * 修改代收记录状态
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean updateCollectionRecordStatus(@Validated List<ModifyCollectionRecordReqDto> dtos) {
        dtos.forEach(e -> {
            CollectionRecord collectionRecord = collectionRecordAssembler.toEntity(e);
            collectionRecordRepository.updateStatus(collectionRecord);
        });
        return true;
    }
}
