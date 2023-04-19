package com.agree.collectionpay.domain.pay.valueobject;

import lombok.Builder;
import lombok.Getter;

/**
 * @author xulingfeng
 * @date 2023/4/19
 * @description 支付结果
 */
@Getter
@Builder
public class PayResult {
    /**
     * 代收结果
     */
    private PayResultEnum payResult;

    /**
     * 流水号
     */
    private String accountSerialNumber;


    public boolean isSuccess() {
        return payResult == PayResultEnum.SUCCESS;
    }
}
