package com.agree.collectionpay.application.payableInfo.service;

import com.agree.collectionpay.application.payRecord.assembler.PayRecordAssembler;
import com.agree.collectionpay.application.payRecord.dto.PayRecordResDto;
import com.agree.collectionpay.application.payableInfo.assembly.PayableInfoAssembler;
import com.agree.collectionpay.application.payableInfo.dto.ExecutePayReqDto;
import com.agree.collectionpay.application.payableInfo.dto.PayableInfoReqDto;
import com.agree.collectionpay.application.payableInfo.dto.PayableInfoResDto;
import com.agree.collectionpay.application.support.AccountInfoSupport;
import com.agree.collectionpay.application.support.CommercialTenantContractSupport;
import com.agree.collectionpay.application.support.PayableInfoSupport;
import com.agree.collectionpay.domain.payRecord.PayRecordFactory;
import com.agree.collectionpay.domain.payRecord.entity.PayRecord;
import com.agree.collectionpay.domain.payRecord.repository.PayRecordRepository;
import com.agree.collectionpay.domain.payableInfo.entity.PayableInfo;
import com.agree.collectionpay.domain.valueobject.AccountInfo;
import com.agree.collectionpay.domain.valueobject.CommercialTenantContract;
import com.agree.collectionpay.domain.valueobject.PayResultEnum;
import com.agree.common.mq.BaseMqMessage;
import com.alibaba.fastjson2.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Map;

/**
 * @author xulingfeng
 * @date 2023/3/23
 * @description 缴费信息
 */
public class PayableInfoService {

    @Autowired
    private CommercialTenantContractSupport contractSupport;
    @Autowired
    private AccountInfoSupport accountInfoSupport;
    private static final String TOPIC = "PAY_SUCCESS";
    private static final String CHECK_ROLE_CODE = "CODE";
    @Autowired
    private PayableInfoSupport payableInfoSupport;
    @Autowired
    private PayRecordRepository payRecordRepository;
    @Autowired
    private KafkaTemplate<String, BaseMqMessage> kafkaTemplate;
    @Autowired
    private PayRecordAssembler payRecordAssembler;
    @Autowired
    private PayableInfoAssembler payableInfoAssembler;

    /**
     * 在三方商户查询应缴信息
     *
     * @return
     */
    public PayableInfoResDto queryPayableInfo(String userCode, String commercialTenantContractId) {
        //查询商户合约
        return payableInfoAssembler.toDto(payableInfoSupport.queryPayableInfo(userCode, commercialTenantContractId));
    }


    /**
     * 单笔缴费
     *
     * @return
     */
    public PayRecordResDto singlePay(PayableInfoReqDto payableInfoDto) {
        PayableInfo payableInfo = payableInfoAssembler.toEntity(payableInfoDto);
        //查询商户合约
        CommercialTenantContract commercialTenantContract = contractSupport.queryContract(payableInfoDto.getCommercialTenantContractId(), payableInfoDto.getUserCode());
        //校验商户合约状态
        commercialTenantContract.checkStatusIfNormal();
        //校验商户账户信息
        accountInfoSupport.checkAccountInfo(commercialTenantContract.getSettlementAccountInfo().getId(), CHECK_ROLE_CODE);
        //校验客户账户信息
        accountInfoSupport.checkAccountInfo(payableInfo.getCustomerAccountInfo().getId(), CHECK_ROLE_CODE);
        //查询客户账户信息
        AccountInfo accountInfo = accountInfoSupport.queryAccountInfo(payableInfoDto.getCustomerAccountInfoId());
        //补全应缴信息
        payableInfo.completePayableInfo(commercialTenantContract, accountInfo);
        //执行缴费
        Map<String, Object> result = accountInfoSupport.executeCollection(ExecutePayReqDto.builder().receiveAccountInfoId(commercialTenantContract.getSettlementAccountInfo().getId()).payAccountInfoId(payableInfoDto.getCustomerAccountInfoId()).amount(payableInfoDto.getAmount()).build());
        //生成缴费记录
        PayRecord payRecord = PayRecordFactory.toEntity(payableInfo, result);
        //保存记录
        payRecordRepository.saveRecord(payRecord);
        //发送通知
        notice(payRecord, result);
        return payRecordAssembler.toDto(payRecord);
    }

    private void notice(PayRecord payRecord, Map<String, Object> result) {
        // 成功则通知商户
        if (PayResultEnum.SUCCESS==result.get("result")) {
            PayRecordResDto dto = payRecordAssembler.toDto(payRecord);
            BaseMqMessage message = BaseMqMessage.builder().topic(TOPIC).data(JSONObject.toJSONString(dto)).build();
            kafkaTemplate.send(TOPIC, message);
        }
        //通知客户缴费结果 调用发送sms的接口
    }
}
