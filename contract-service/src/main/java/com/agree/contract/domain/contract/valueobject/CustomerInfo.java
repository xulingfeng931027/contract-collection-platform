package com.agree.contract.domain.contract.valueobject;

import com.agree.common.ddd.obj.AbstractValueObject;
import com.agree.contract.domain.contract.valueobject.enumType.CustomerStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.apache.kafka.common.errors.ApiException;

/**
 * @author xulingfeng
 * 
 * @description 客户信息
 */
@Getter
@Builder
@AllArgsConstructor
public class CustomerInfo  extends AbstractValueObject {

    /**
     * 名称
     */
    private String name;
    /**
     * 电话
     */
    private String phone;
    /**
     * 状态
     */
    private CustomerStatusEnum status;
    /**
     * 用户编码
     */
    private String userCode;
    /**
     * 证件号
     */
    private String idCard;

    /**
     * 判定客户状态是否正常
     */
    public void checkStatusIfNormal() {
        if (status != CustomerStatusEnum.NORMAL) {
            throw new ApiException("客户状态不正常");
        }
    }

//    public boolean statusIsNormal() {
//        return status == CustomerStatusEnum.NORMAL;
//    }
}

