package com.agree.collectionpay.application.pay.payableInfo.service;

import com.agree.collectionpay.application.pay.payRecord.assembler.PayRecordAssembler;
import com.agree.collectionpay.application.pay.payRecord.dto.PayRecordResDto;
import com.agree.collectionpay.application.pay.payableInfo.assembly.PayableInfoAssembler;
import com.agree.collectionpay.application.pay.payableInfo.dto.ExecutePayReqDto;
import com.agree.collectionpay.application.pay.payableInfo.dto.PayableInfoReqDto;
import com.agree.collectionpay.application.pay.payableInfo.dto.PayableInfoResDto;
import com.agree.collectionpay.application.pay.support.ContractSupport;
import com.agree.collectionpay.application.pay.support.PayableInfoSupport;
import com.agree.collectionpay.application.support.AccountInfoSupport;
import com.agree.collectionpay.domain.pay.payRecord.PayRecordFactory;
import com.agree.collectionpay.domain.pay.payRecord.entity.PayRecord;
import com.agree.collectionpay.domain.pay.payRecord.repository.PayRecordRepository;
import com.agree.collectionpay.domain.pay.payableinfo.entity.PayableInfo;
import com.agree.collectionpay.domain.pay.valueobject.AccountInfo;
import com.agree.collectionpay.domain.pay.valueobject.CommercialTenantContract;
import com.agree.collectionpay.domain.pay.valueobject.PayResultEnum;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @author xulingfeng
 * 
 * @description 缴费信息
 */
public class PayableInfoService {

    @Autowired
    private ContractSupport contractSupport;
    @Autowired
    private AccountInfoSupport accountInfoSupport;
    private static final String TOPIC = "PAY_SUCCESS";
    @Autowired
    private PayableInfoSupport payableInfoSupport;
    @Autowired
    private PayRecordRepository payRecordRepository;
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
        CommercialTenantContract commercialTenantContract = contractSupport.queryCommercialTenantContract(payableInfoDto.getCommercialTenantContractId());
        //校验商户合约状态
        commercialTenantContract.checkStatusIfNormal();
        //校验商户账户信息
        accountInfoSupport.checkAccountInfo(commercialTenantContract.getSettlementAccountInfo().getId());
        //校验客户账户信息
        accountInfoSupport.checkAccountInfo(payableInfo.getCustomerAccountInfo().getId());
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
        if (PayResultEnum.SUCCESS == result.get("result")) {
            //发送mq
        }
        //通知客户缴费结果 调用发送sms的接口
    }
}
