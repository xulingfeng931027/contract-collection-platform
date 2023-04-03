package com.agree.collection.application.collectionrecord.service;

import com.agree.collection.application.collectionrecord.assembler.CollectionRecordAssembler;
import com.agree.collection.application.collectionrecord.dto.ModifyCollectionRecordReqDto;
import com.agree.collection.domain.collectionRecord.entity.CollectionRecord;
import com.agree.collection.domain.collectionRecord.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * @author xulingfeng
 * @description 代收记录服务
 * @date 2023/2
 */
@Service
public class CollectionRecordService {

    @Autowired
    private CollectionRepository collectionRecordRepository;

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
        return collectionRecordRepository.save(collectionRecord);
    }
}
