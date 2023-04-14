package com.agree.collectionpay.application.pay.support;


import com.agree.collectionpay.domain.pay.payableinfo.entity.PayableInfo;

/**
 * @author xulingfeng
 * 
 * @description 防腐层  调用账户系统
 * 
 */
public interface PayableInfoSupport {


    PayableInfo queryPayableInfo(String projectCode, String userCode);

}
