package com.agree.collection.infrastructure.payRecord.repositoryImpl;

import com.agree.collection.domain.payRecord.entity.PayRecord;
import com.agree.collection.domain.payRecord.repository.PayRecordRepository;
import com.agree.collection.infrastructure.payRecord.mapper.PayRecordMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xulingfeng
 * @date 2023/2
 */
@Repository
@Slf4j
public class PayRecordRepositoryImpl implements PayRecordRepository {

    @Autowired
    private PayRecordMapper payRecordMapper;


    /**
     * 保存
     */
    @Override
    public Integer saveRecord(PayRecord payRecord) {
        return null;
    }

    /**
     * 查询缴费记录
     *
     * @return
     */
    @Override
    public List<PayRecord> queryRecordPage(PayRecord payRecordPo) {
        return null;
    }

}
