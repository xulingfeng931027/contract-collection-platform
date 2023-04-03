package com.agree.collection.domain.collectionRecord.repository;

import com.agree.collection.domain.collectionRecord.entity.CollectionRecord;

/**
 * @author xulingfeng
 * @className BillingRecordRepository
 * @description 计费记录仓储接口
 * @date 2023/2
 */
public interface CollectionRepository {


    String save(CollectionRecord collectionRecord);

    /**
     * 修改代收记录状态
     * @param collectionRecord
     * @return
     */
    Integer updateStatus(CollectionRecord collectionRecord);
}
