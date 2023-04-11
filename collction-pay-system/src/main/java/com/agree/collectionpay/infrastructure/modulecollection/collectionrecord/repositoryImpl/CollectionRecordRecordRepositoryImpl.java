package com.agree.collectionpay.infrastructure.modulecollection.collectionrecord.repositoryImpl;

import com.agree.collectionpay.domain.modulecollection.collectionRecord.entity.CollectionRecord;
import com.agree.collectionpay.domain.modulecollection.collectionRecord.repository.CollectionRecordRepository;
import com.agree.collectionpay.infrastructure.modulecollection.collectionrecord.mapper.CollectionRecordMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author xulingfeng
 * @className BillingRecordRepositoryImpl
 * @description 代收记录仓储接口实现
 * 
 */
@Repository
@Slf4j
public class CollectionRecordRecordRepositoryImpl implements CollectionRecordRepository {

    @Autowired
    private CollectionRecordMapper collectionRecordMapper;

    @Override
    public String saveRecord(CollectionRecord collectionRecord) {
        return null;
    }

    /**
     * 修改代收记录状态
     *
     * @param collectionRecord
     * @return
     */
    @Override
    public Integer updateStatus(CollectionRecord collectionRecord) {
        return null;
    }
}
