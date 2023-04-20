package com.agree.collectionpay.domain.collection.collectionRecord.repository;

import com.agree.collectionpay.domain.collection.collectionRecord.entity.CollectionRecord;

import java.util.List;

/**
 * @author xulingfeng
 * @description 代收记录仓储接口
 * 
 */
public interface CollectionRecordRepository {

    /**
     * 保存代收记录
     * @param collectionRecord
     * @return
     */
    String saveRecord(CollectionRecord collectionRecord);

    /**
     * 批量保存
     * @param collectionRecordList
     * @return
     */
    String saveRecordBatch(List<CollectionRecord> collectionRecordList);
    /**
     * 修改代收记录状态
     *
     * @return 1表示成功
     */
    Integer updateStatus(CollectionRecord collectionRecord);
}
