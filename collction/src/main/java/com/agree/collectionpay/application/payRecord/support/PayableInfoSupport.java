package com.agree.collectionpay.application.payRecord.support;


import com.agree.collectionpay.domain.payableInfo.entity.PayableInfo;

/**
 * @author xulingfeng
 * @className NumberSupport
 * @description 防腐层  调用账户系统
 * @date 2022/9/11
 */
public interface PayableInfoSupport {


    PayableInfo queryPayableInfo(String projectCode, String userCode);

}