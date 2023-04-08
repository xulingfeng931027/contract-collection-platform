package com.agree.collectionpay.interfaces.web;

import com.agree.collectionpay.application.modulepay.payRecord.dto.PayRecordReqDto;
import com.agree.collectionpay.application.modulepay.payRecord.dto.PayRecordResDto;
import com.agree.collectionpay.application.modulepay.payRecord.service.PayRecordService;
import com.agree.common.web.Response;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xulingfeng
 * @className BillingController
 * @description 缴费控制器
 * @date 2023/3/11
 */
@Api("签约接口")
@RestController
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private PayRecordService payRecordService;


    @PostMapping("/query")
    public Response<IPage<PayRecordResDto>> queryRecord(@RequestBody PayRecordReqDto dto) {
        return Response.ok(payRecordService.queryPageRecord(dto));
    }

}