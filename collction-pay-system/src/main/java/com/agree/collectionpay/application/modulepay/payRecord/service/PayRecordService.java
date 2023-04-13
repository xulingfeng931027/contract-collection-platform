package com.agree.collectionpay.application.modulepay.payRecord.service;

import com.agree.collectionpay.application.modulepay.payRecord.assembler.PayRecordAssembler;
import com.agree.collectionpay.application.modulepay.payRecord.dto.PayRecordReqDto;
import com.agree.collectionpay.application.modulepay.payRecord.dto.PayRecordResDto;
import com.agree.collectionpay.domain.modulepay.payRecord.entity.PayRecord;
import com.agree.collectionpay.domain.modulepay.payRecord.repository.PayRecordRepository;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xulingfeng
 * 
 * @description
 */
public class PayRecordService {

    @Autowired
    private PayRecordRepository payRecordRepository;
    @Autowired
    private PayRecordAssembler payRecordAssembler;


    /**
     * 分页查询缴费记录
     *
     * @return
     */
    public IPage<PayRecordResDto> queryPageRecord(PayRecordReqDto payRecordReqDto) {
        PayRecord payRecord = payRecordAssembler.toEntity(payRecordReqDto);
        Page<PayRecord> payRecordPage = payRecordRepository.queryRecordPage(payRecord);
        return payRecordPage.convert(payRecordAssembler::toDto);
    }
}
