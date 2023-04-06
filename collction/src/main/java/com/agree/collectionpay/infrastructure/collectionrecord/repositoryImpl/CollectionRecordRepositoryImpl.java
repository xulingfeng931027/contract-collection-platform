package com.agree.collectionpay.infrastructure.collectionrecord.repositoryImpl;

import com.agree.collectionpay.domain.collectionRecord.entity.CollectionRecord;
import com.agree.collectionpay.domain.collectionRecord.repository.CollectionRepository;
import com.agree.collectionpay.infrastructure.collectionrecord.mapper.CollectionRecordMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author xulingfeng
 * @className BillingRecordRepositoryImpl
 * @description 代收记录仓储接口实现
 * @date 2023/2
 */
@Repository
@Slf4j
public class CollectionRecordRepositoryImpl implements CollectionRepository {

    @Autowired
    private CollectionRecordMapper collectionRecordMapper;

    @Override
    public String save(CollectionRecord collectionRecord) {
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
