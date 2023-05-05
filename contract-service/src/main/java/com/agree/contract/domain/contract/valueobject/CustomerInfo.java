package com.agree.contract.domain.contract.valueobject;

import com.agree.common.ddd.obj.AbstractValueObject;
import com.agree.contract.domain.contract.exception.ContractException;
import com.agree.contract.domain.contract.valueobject.enumType.CustomerStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import static com.agree.contract.domain.contract.exception.ContractErrorCode.CUSTOMER_STATUS_NOT_NORMAL;

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
            throw new ContractException(CUSTOMER_STATUS_NOT_NORMAL);
        }
    }

//    public boolean statusIsNormal() {
//        return status == CustomerStatusEnum.NORMAL;
//    }
}

