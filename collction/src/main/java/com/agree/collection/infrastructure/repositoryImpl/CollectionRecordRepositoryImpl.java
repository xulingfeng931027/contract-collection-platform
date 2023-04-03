package com.agree.collection.infrastructure.repositoryImpl;

import com.agree.collection.domain.collectionInfo.entity.CollectionInfo;
import com.agree.collection.domain.collectionRecord.repository.CollectionRepository;
import com.agree.collection.infrastructure.mapper.CollectionMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

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
    private CollectionMapper collectionMapper;

    /**
     * 保存商户合约
     *
     * @param collectionInfo
     * @param result
     * @return
     */
    @Override
    public Integer saveRecord(CollectionInfo collectionInfo, Map<String, Object> result) {
        return null;
    }
}
