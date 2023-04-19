package com.agree.collectionpay.application.pay.support;


import com.agree.collectionpay.domain.pay.payableinfo.entity.PayableInfo;

/**
 * @author xulingfeng
 * 
 * @description 防腐层  调用账户系统
 * 
 */
public interface PayableInfoSupport {

    /**
     * 查商户合约
     * @param contractId 合约id
     * @param userCode 用户编号
     * @return
     */
    PayableInfo queryPayableInfo(String contractId, String userCode);

}
