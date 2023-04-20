package com.agree.collectionpay.infrastructure.collection.collectionrecord.repositoryImpl;

import com.agree.collectionpay.domain.collection.collectionRecord.entity.CollectionRecord;
import com.agree.collectionpay.domain.collection.collectionRecord.repository.CollectionRecordRepository;
import com.agree.collectionpay.infrastructure.collection.collectionrecord.mapper.CollectionRecordMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xulingfeng
 *
 * @description 代收记录仓储接口实现
 *
 */
@Repository
@Slf4j
public class CollectionRecordRecordRepositoryImpl implements CollectionRecordRepository {

    @Autowired
    private CollectionRecordMapper collectionRecordMapper;

    /**
     * 保存代收记录
     *
     * @return
     */
    @Override
    public String saveRecord(CollectionRecord collectionRecord) {
        return null;
    }

    /**
     * 批量保存代收记录
     *
     * @return
     */
    @Override
    public String saveRecordBatch(List<CollectionRecord> collectionRecordList) {
        return null;
    }

    /**
     * 修改代收记录状态
     *
     * @return 1表示成功
     */
    @Override
    public Integer updateStatus(CollectionRecord collectionRecord) {
        return null;
    }
}
