package com.agree.pay.domain.payRecord;

import com.agree.pay.domain.payRecord.entity.PayRecord;
import com.agree.pay.domain.payableInfo.entity.PayableInfo;
import com.agree.pay.domain.valueobject.PayResultEnum;

import java.util.Map;

/**
 * @author xulingfeng
 * @date 2023/3/26
 * @description
 */
public class PayRecordFactory {
    public static PayRecord toEntity(PayableInfo payableInfo, Map<String, Object> result) {
        return PayRecord.builder()
                .amount(payableInfo.getAmount())
                .payStatus((PayResultEnum) result.get("payStatus"))
                .payInfoCode(payableInfo.getPayInfoCode())
                .userCode(payableInfo.getUserCode())
                .commercialTenantContract(payableInfo.getCommercialTenantContract())
                .customerAccountInfo(payableInfo.getCustomerAccountInfo()).build();
    }

}
