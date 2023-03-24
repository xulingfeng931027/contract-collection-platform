package com.zantong.pay.application.service;

import com.zantong.pay.application.assembly.PayableInfoAssembler;
import com.zantong.pay.application.dto.PayableInfoDto;
import com.zantong.pay.application.support.PayableInfoSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xulingfeng
 * @date 2023/3/23
 * @description
 */
public class PayableInfoService {

    @Autowired
    private PayableInfoSupport payableInfoSupport;

    public PayableInfoDto queryPayableInfo(String projectCode, String userCode) {
        return PayableInfoAssembler.INSTANCE.toDto(payableInfoSupport.queryPayableInfo(projectCode, userCode));
    }
}
