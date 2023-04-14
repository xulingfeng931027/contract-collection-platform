package com.agree.collectionpay.domain.modulecollection.collectionRecord.repository;

import com.agree.collectionpay.domain.modulecollection.collectionRecord.entity.CollectionRecord;

/**
 * @author xulingfeng
 * @description 代收记录仓储接口
 * 
 */
public interface CollectionRecordRepository {


    String saveRecord(CollectionRecord collectionRecord);

    /**
     * 修改代收记录状态
     *
     * @param collectionRecord
     * @return
     */
    Integer updateStatus(CollectionRecord collectionRecord);
}
