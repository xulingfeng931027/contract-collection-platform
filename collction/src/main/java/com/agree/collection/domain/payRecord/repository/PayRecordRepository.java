package com.agree.collection.domain.payRecord.repository;

import com.agree.collection.domain.payRecord.entity.PayRecord;

import java.util.List;

/**
 * @author xulingfeng
 * @className BillingRecordRepository
 * @description 计费记录仓储接口
 * @date 2023/2
 */
public interface PayRecordRepository {


    Integer saveRecord(PayRecord payRecord);

    List<PayRecord> queryRecordPage(PayRecord payRecord);

}
