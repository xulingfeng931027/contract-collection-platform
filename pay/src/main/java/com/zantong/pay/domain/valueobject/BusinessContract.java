package com.zantong.pay.domain.valueobject;

import com.zantong.common.api.AbstractValueObject;
import lombok.Value;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description
 */
@Value
public class BusinessContract extends AbstractValueObject {
    /**
     * 合约id
     */
    private String id;
    /**
     * 收费种类
     */
    private String chargeType;


    private Integer status;

    private String accountId;

    public boolean checkStatus() {
        return status == 1;
    }

}
