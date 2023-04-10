package com.agree.collectionpay.interfaces.web;

import com.agree.collectionpay.application.modulecollection.collectionInfo.service.CollectionInfoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xulingfeng
 * @className BillingController
 * @description
 * @date 2023/3/11
 */
@Api("签约接口")
@RestController
@RequestMapping("/collction/record")
public class CollectionRecordController {

    @Autowired
    private CollectionInfoService contractService;

}
