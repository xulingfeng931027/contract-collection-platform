package com.zantong.pay.adapter.web;

import com.zantong.common.api.Response;
import com.zantong.contract.application.service.CustomerContractService;
import com.zantong.pay.application.assembly.PayableInfoAssembler;
import com.zantong.pay.application.dto.PayRecordDto;
import com.zantong.pay.application.service.PayRecordService;
import com.zantong.pay.domain.payRecordAggregation.entity.PayRecord;
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
    private CustomerContractService customerContractService;
    @Autowired
    private PayRecordService payRecordService;


    @PostMapping("/query")
    public Response<PayRecordDto> queryRecord(@RequestBody PayRecordDto dto) {
        List<PayRecord> payRecords = payRecordService.queryPageRecord(dto);
        return Response.ok(PayableInfoAssembler.INSTANCE.toDto(payRecords));
    }

}
