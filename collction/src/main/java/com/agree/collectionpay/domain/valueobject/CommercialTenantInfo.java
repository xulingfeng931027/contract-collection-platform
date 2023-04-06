package com.agree.collectionpay.domain.valueobject;

import com.agree.contract.domain.valueobject.CommercialTenantStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.apache.kafka.common.errors.ApiException;

/**
 * //todo   值对象 需要单独定义值对象的dto 不要直接引用领域层的值对象 在应用层不分实体和值对象 全都是dto???  dto需要分req和res
 * @author xulingfeng
 * @date 2023/3/17
 * @description 商户信息
 * todo
 * 1.值对象没有id,生命周期,依赖于实体存在
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
     * 校验商户状态 fixme 不当命名
     */
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
            throw new ApiException("商户状态不正常");
        }
    }
}
