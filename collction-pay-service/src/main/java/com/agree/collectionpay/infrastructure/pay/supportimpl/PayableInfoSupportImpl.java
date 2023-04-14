package com.agree.collectionpay.infrastructure.pay.supportimpl;


import com.agree.collectionpay.application.pay.support.PayableInfoSupport;
import com.agree.collectionpay.domain.pay.payableinfo.entity.PayableInfo;

/**
 * @author xulingfeng
 * 
 * @description 防腐层  调用商户系统查应缴
 * 
 */
public class PayableInfoSupportImpl implements PayableInfoSupport {


    @Override
    public PayableInfo queryPayableInfo(String projectCode, String userCode) {
        return null;
    }
}
