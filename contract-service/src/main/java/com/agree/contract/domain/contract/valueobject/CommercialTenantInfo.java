package com.agree.contract.domain.contract.valueobject;

import com.agree.common.ddd.obj.AbstractValueObject;
import com.agree.contract.domain.contract.exception.ContractException;
import com.agree.contract.domain.contract.valueobject.enumType.CommercialTenantStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import static com.agree.contract.domain.contract.exception.ContractErrorCode.COMMERCIAL_TENANT_STATUS_NOT_NORMAL;

/**
 * @author xulingfeng
 * 
 * @description 商户信息
 */
@Getter
@Builder
@AllArgsConstructor
public class CommercialTenantInfo  extends AbstractValueObject {
    /**
     * 商户名称
     */
    private String name;
    /**
     * 商户电话
     */
    private String phone;
    /**
     * 商户状态
     */
    private CommercialTenantStatusEnum status;

    /**
     * 法人证件号
     */
    private String legalPersonNumber;
    /**
     * 纳税人编码
     */
    private String taxPayerNumber;

    /**
     * 判定商户状态是否正常
     */
    public void checkStatusIfNormal() {
        if (status != CommercialTenantStatusEnum.NORMAL) {
            throw new ContractException(COMMERCIAL_TENANT_STATUS_NOT_NORMAL);
        }
    }
}
