package com.agree.contract.application.modulecontract.support;

import com.agree.contract.domain.modulecontract.valueobject.CommercialTenantInfo;

/**
 * @author xulingfeng
 * @className NumberSupport
 * @description 商户系统防腐层接口
 * todo 1.封装第三方系统的调用过程
 *      2.封装第三方获取的数据对象到本系统相关数据对象的转换过程
 *      3.应用程的流程编排在调用该接口的时候不需要关心具体调用过程,并且直接拿到的是领域层的对象
 *      4.当商户系统的调用过程或对象发生变动时,只需要修正防腐层的实现即可,代码影响范围最小
 *
 */
public interface CommercialTenantInfoSupport {
    /**
     * 查询商户信息
     * 调用三方商户信息系统接口
     * @return 商户信息
     */
    CommercialTenantInfo queryCommercialTenantInfo(String idCard);
}
