package com.agree.collectionpay.domain.payRecord.repository;

import com.agree.collectionpay.domain.payRecord.entity.PayRecord;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author xulingfeng
 * @className BillingRecordRepository
 * @description 计费记录仓储接口
 * @date 2023/2
 */
public interface PayRecordRepository {


    Integer saveRecord(PayRecord payRecord);

    Page<PayRecord> queryRecordPage(PayRecord payRecord);

}
