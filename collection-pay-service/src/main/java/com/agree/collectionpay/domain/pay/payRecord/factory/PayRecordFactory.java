package com.agree.collectionpay.domain.pay.payRecord.factory;

import com.agree.collectionpay.domain.pay.payRecord.entity.PayRecord;
import com.agree.collectionpay.domain.pay.payableinfo.entity.PayableInfo;
import com.agree.collectionpay.domain.pay.valueobject.PayResult;

/**
 * @author xulingfeng
 * 
 * @description
 */
public class PayRecordFactory {
    public static PayRecord toEntity(PayableInfo payableInfo, PayResult result) {
        return PayRecord.builder()
                .amount(payableInfo.getAmount())
                .payStatus(result.getPayResult())
                .payInfoCode(payableInfo.getPayInfoCode())
                .userCode(payableInfo.getUserCode())
                .commercialTenantContractId(payableInfo.getCommercialTenantContract().getId())
                .customerAccountInfo(payableInfo.getCustomerAccountInfo()).build();
    }

}
