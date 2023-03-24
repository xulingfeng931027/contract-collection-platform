package com.zantong.pay.domain.payableInfoAggregation.repository;

import com.zantong.pay.domain.payRecordAggregation.entity.PayRecord;

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
