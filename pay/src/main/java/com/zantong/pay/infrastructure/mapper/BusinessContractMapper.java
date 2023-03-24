package com.zantong.pay.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zantong.contract.infrastructure.po.BusinessContractPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xulingfeng
 * @className BillingRecordMapper
 * @description
 * @date 2023/2
 */
@Mapper
public interface BusinessContractMapper extends BaseMapper<BusinessContractPo> {

}
