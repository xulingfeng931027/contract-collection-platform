package com.agree.collectionpay.infrastructure.pay.supportimpl;


import com.agree.collectionpay.application.pay.support.PayableInfoSupport;
import com.agree.collectionpay.domain.pay.payableinfo.entity.PayableInfo;
import org.springframework.stereotype.Service;

/**
 * @author xulingfeng
 * 
 * @description 防腐层  调用商户系统查应缴
 * 
 */
@Service
public class PayableInfoSupportImpl implements PayableInfoSupport {


    @Override
    public PayableInfo queryPayableInfo(String contractId, String userCode) {
        return null;
    }
}
