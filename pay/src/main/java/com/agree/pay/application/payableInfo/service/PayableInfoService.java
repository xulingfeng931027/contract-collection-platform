package com.agree.pay.application.payableInfo.service;

import com.agree.pay.application.payRecord.support.AccountInfoSupport;
import com.agree.pay.application.payRecord.support.CommercialTenantContractSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xulingfeng
 * @date 2023/3/23
 * @description 缴费信息
 */
public class PayableInfoService {

    @Autowired
    private CommercialTenantContractSupport contractSupport;
    @Autowired
    private AccountInfoSupport accountInfoSupport;


    /**
     * 查询应缴信息
     *
     * @return
     */

}
