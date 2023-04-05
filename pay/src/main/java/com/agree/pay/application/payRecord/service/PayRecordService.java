package com.agree.pay.application.payRecord.service;

import com.agree.common.mq.BaseMqMessage;
import com.agree.pay.application.payRecord.assembler.PayRecordAssembler;
import com.agree.pay.application.payRecord.dto.PayRecordReqDto;
import com.agree.pay.application.payRecord.support.AccountInfoSupport;
import com.agree.pay.application.payRecord.support.CommercialTenantContractSupport;
import com.agree.pay.application.payableInfo.assembly.PayableInfoAssembler;
import com.agree.pay.domain.payRecord.entity.PayRecord;
import com.agree.pay.domain.payRecord.repository.PayRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.List;

/**
 * @author xulingfeng
 * @date 2023/3/23
 * @description
 */
public class PayRecordService {

    private static final String TOPIC = "PAY_SUCCESS";
    @Autowired
    private AccountInfoSupport accountInfoSupport;
    @Autowired
    private PayRecordRepository payRecordRepository;
    @Autowired
    private CommercialTenantContractSupport contractSupport;
    @Autowired
    private KafkaTemplate<String, BaseMqMessage> kafkaTemplate;
    @Autowired
    private PayRecordAssembler payRecordAssembler;
    @Autowired
    private PayableInfoAssembler payableInfoAssembler;




    /**
     * 查询缴费记录
     *
     * @return
     */
    public List<PayRecord> queryPageRecord(PayRecordReqDto payRecordReqDto) {
        PayRecord payRecord = payRecordAssembler.toEntity(payRecordReqDto);
        return payRecordRepository.queryRecordPage(payRecord);
    }
}
