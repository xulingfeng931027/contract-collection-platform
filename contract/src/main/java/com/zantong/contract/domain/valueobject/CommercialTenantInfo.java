package com.zantong.contract.domain.valueobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.apache.kafka.common.errors.ApiException;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author xulingfeng
 * @date 2023/3/17
 * @description 商户信息
 * todo 值对象
 *   1.值对象没有id,生命周期,依赖于实体存在
 * 2.值对象是不可变的,所以不应该有set方法
 * 3.值对象的属性如果发生变动 应该生成一个新的值对象整个替换
 * 例如这里的商户信息值对象 只是合约申请单里面的商户信息的一个数据快照.签约完成后,
 * 即便商户信息发生变化,也不应该影响合约申请单里面的商户信息
 */
@Getter
@Builder
@AllArgsConstructor
//@Value
public class CommercialTenantInfo {
    /**
     * 商户名称
     */
    @NotBlank
    private String name;
    /**
     * 商户电话
     */
    @NotBlank
    private String phone;
    /**
     * 商户状态
     */
    private CommercialTenantStatusEnum status;

    /**
     * 法人证件号
     */
    @NotBlank
    @Length(min = 18, max = 18)
    private String legalPersonNumber;
    /**
     * 纳税人编码
     */
    @NotBlank
    private String taxPayerNumber;

    /**
     * 校验商户状态
     */
    public boolean checkStatus() {
        //todo 1-1 : 充血方法,异常定义以及抛出
        // 1.定义异常基类
        // 2.继承基类定义商户合约异常
        // 3.异常里面有errorCode和msg
        // 4.业务异常需继承exception异常 需要在方法上抛出 提醒调用方手动处理异常
        // 5.参数校验使用runtime异常
        return status == CommercialTenantStatusEnum.NORMAL;
    }

    /**
     * 判定商户状态是否正常
     */
    public void checkStatusIfNormal() {
        //todo 1-2(优化) :  充血方法的名称尽量体现于业务含义
        // 充血方法更接近于业务流程的概念
        // 如果方法执行失败流程中断就直接抛出异常,
        // 如果方法执行的结果可以影响到后续流程执行 就返回boolean值或者其他类型的结果
        if (status != CommercialTenantStatusEnum.NORMAL) {
            throw new ApiException("商户状态不正确");
        }
    }

    /**
     * 校验商户法人证件号
     */
    public void checkLegalPersonNumberIfValid() {
        //todo 1-3 优化
        // 证件号也可以通过自定义注解实现校验 后续可以不断积累和完善具有业务含义的相关校验
        // 校验商户法人证件号是否合法
    }
}
