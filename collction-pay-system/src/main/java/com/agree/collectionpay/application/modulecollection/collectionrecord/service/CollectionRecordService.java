package com.agree.collectionpay.application.modulecollection.collectionrecord.service;

import com.agree.collectionpay.application.collectionrecord.assembler.CollectionRecordAssembler;
import com.agree.collectionpay.application.collectionrecord.dto.ModifyCollectionRecordReqDto;
import com.agree.collectionpay.domain.modulecollection.collectionRecord.entity.CollectionRecord;
import com.agree.collectionpay.domain.modulecollection.collectionRecord.repository.CollectionRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * @author xulingfeng
 * @description 代收记录服务
 * @date 2023/3/11
 */
@Service
public class CollectionRecordService {

    @Autowired
    private CollectionRecordRepository collectionRecordRepository;

    /**
     * 修改代收记录状态
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean updateCollectionRecordStatus(@Validated List<ModifyCollectionRecordReqDto> dtos) {
        dtos.forEach(e -> {
            CollectionRecord collectionRecord = CollectionRecordAssembler.INSTANCE.toEntity(e);
            collectionRecordRepository.updateStatus(collectionRecord);
        });
        return true;
    }

    public String save(CollectionRecord collectionRecord) {
        return collectionRecordRepository.saveRecord(collectionRecord);
    }
}
