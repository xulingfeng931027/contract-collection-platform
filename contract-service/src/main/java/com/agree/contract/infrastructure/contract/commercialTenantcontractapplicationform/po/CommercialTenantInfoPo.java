package com.agree.contract.infrastructure.contract.commercialTenantcontractapplicationform.po;

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

    /**
     * 校验商户状态 fixme 反例  不当命名
     */
    @Deprecated
    public boolean checkStatus() {
        return status == CommercialTenantStatusEnum.NORMAL;
    }

    /**
     * 判定商户状态是否正常
     */
    public void checkStatusIfNormal() {
        //todo 1-1 : 充血方法,异常定义以及抛出
        // 1.定义异常基类
        // 2.继承基类定义商户合约异常
        // 3.异常里面有errorCode和msg
        // 4.业务异常需继承exception异常 需要在方法上抛出 提醒调用方手动处理异常
        // 5.参数校验使用runtime异常
        //todo 1-2(优化) :  充血方法的名称尽量体现于业务含义
        // 充血方法更接近于业务流程的概念
        // 如果方法执行失败流程中断就直接抛出异常,
        // 如果方法执行的结果可以影响到后续流程执行 就返回boolean值或者其他类型的结果
        // 1-3 此处方法名也可以叫做 statusIsNormal  更贴近业务含义 这里我们只关心具体的状态 不关心状态变化的原因和规则。
        if (status != CommercialTenantStatusEnum.NORMAL) {
            throw new ContractException(COMMERCIAL_TENANT_STATUS_NOT_NORMAL);
        }
    }
}
