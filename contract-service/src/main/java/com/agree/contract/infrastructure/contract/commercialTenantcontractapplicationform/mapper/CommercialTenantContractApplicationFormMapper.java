package com.agree.contract.infrastructure.contract.commercialTenantcontractapplicationform.mapper;

import com.agree.contract.infrastructure.contract.commercialTenantcontractapplicationform.po.CommercialTenantContractApplicationFormPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xulingfeng
 * @className BillingRecordMapper
 * @description
 * 
 * todo 简单情况下可以直接继承BaseMapper,
 *  但建议使用xml文件来实现数据库字段的映射 因为有时候数据库表字段跟po字段不一致 或者数据库字段需要变动 也可以封装一些sql操作
 *  代码中只需要定义相关接口 未来这些属性或者接口发生变动 只需要替换对应的xml文件即可 没有代码侵入
 *  当然,不建议在xml中写过于复杂的sql语句,建议在仓储层中完成.
 */
@Mapper
public interface CommercialTenantContractApplicationFormMapper extends BaseMapper<CommercialTenantContractApplicationFormPo> {

}
