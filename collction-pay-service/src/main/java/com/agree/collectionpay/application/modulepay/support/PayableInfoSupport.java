package com.agree.collectionpay.application.modulepay.support;


import com.agree.collectionpay.domain.modulepay.payableinfo.entity.PayableInfo;

/**
 * @author xulingfeng
 * 
 * @description 防腐层  调用账户系统
 * 
 */
public interface PayableInfoSupport {


    PayableInfo queryPayableInfo(String projectCode, String userCode);

}
