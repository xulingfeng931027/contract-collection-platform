package com.agree.contract.infrastructure.contract.commercialTenantcontractapplicationform.po;

import com.agree.common.ddd.obj.AbstractValueObject;
import com.agree.contract.domain.contract.valueobject.enumType.CommercialTenantStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @author xulingfeng
 * 
 * @description 商户信息po
 */
@Getter
@Builder
@AllArgsConstructor
public class CommercialTenantInfoPo extends AbstractValueObject {
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
}
