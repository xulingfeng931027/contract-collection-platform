package com.agree.collectionpay.interfaces.web;

import com.agree.collectionpay.application.payRecord.dto.PayRecordReqDto;
import com.agree.collectionpay.application.payRecord.dto.PayRecordResDto;
import com.agree.collectionpay.application.payRecord.service.PayRecordService;
import com.agree.common.api.Response;
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
 * @date 2023/2
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
