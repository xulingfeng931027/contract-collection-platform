package com.zantong.pay.domain.payRecordAggregation.valueobject;

import lombok.Data;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description
 */
@Data
public class BusinessContract {
    /**
     * 合约id
     */
    private String id;
    /**
     * 收费种类
     */
    private String chargeType;

    /**
     * 项目代码
     */
    private String projectCode;

    private Integer status;

    private String accountId;

    public boolean checkStatus() {
        return status == 1;
    }

}
