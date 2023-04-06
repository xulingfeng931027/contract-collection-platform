package com.agree.collectionpay.application.payRecord.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.Date;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description 缴费记录查询
 */
@Data
public class PayRecordReqDto extends Page<PayRecordResDto> {
    /**
     * 商户合约id
     */
    private String commercialTenantContractId;

    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 缴费信息编号
     */
    private String payInfoCode;
    /**
     * 账单时间
     */
    private Date billTime;



}
