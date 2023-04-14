package com.agree.collectionpay.infrastructure.pay.payRecord.repositoryImpl;

import com.agree.collectionpay.domain.pay.payRecord.entity.PayRecord;
import com.agree.collectionpay.domain.pay.payRecord.repository.PayRecordRepository;
import com.agree.collectionpay.infrastructure.pay.payRecord.mapper.PayRecordMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author xulingfeng
 * 
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
    public Page<PayRecord> queryRecordPage(PayRecord payRecordPo) {
        return null;
    }

}
