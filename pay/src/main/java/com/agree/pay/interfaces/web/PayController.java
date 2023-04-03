package com.agree.pay.interfaces.web;

import com.agree.common.api.Response;
import com.agree.pay.application.payRecord.assembler.PayRecordAssembler;
import com.agree.pay.application.payRecord.dto.PayRecordReqDto;
import com.agree.pay.application.payRecord.dto.PayRecordResDto;
import com.agree.pay.application.payRecord.service.PayRecordService;
import com.agree.pay.domain.payRecord.entity.PayRecord;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @Autowired
    private PayRecordAssembler payRecordAssembler;


    @PostMapping("/query")
    public Response<List<PayRecordResDto>> queryRecord(@RequestBody PayRecordReqDto dto) {
        List<PayRecord> payRecords = payRecordService.queryPageRecord(dto);
        return Response.ok(payRecordAssembler.toDto(payRecords));
    }

}
