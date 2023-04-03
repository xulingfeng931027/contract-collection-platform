package com.agree.pay.domain.payRecord;

import com.agree.pay.domain.payRecord.entity.PayRecord;
import com.agree.pay.domain.payableInfo.entity.PayableInfo;
import com.alibaba.fastjson2.JSONObject;

/**
 * @author xulingfeng
 * @date 2023/3/26
 * @description
 */
public class PayRecordFactory {
    public static PayRecord toEntity(PayableInfo payableInfo, JSONObject result) {
        return PayRecord.builder()
                .amount(payableInfo.getAmount())
                .result(result.getInteger("result"))
                .payInfoCode(payableInfo.getPayInfoCode())
                .userCode(payableInfo.getUserCode())
                .businessContract(payableInfo.getBusinessContract())
                .customerAccountInfo(payableInfo.getCustomerAccountInfo()).build();
    }

}
