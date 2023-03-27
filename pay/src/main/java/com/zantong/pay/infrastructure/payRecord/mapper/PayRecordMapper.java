package com.zantong.pay.infrastructure.payRecord.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zantong.pay.infrastructure.payRecord.po.PayRecordPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xulingfeng
 * @className BillingRecordMapper
 * @description
 * @date 2023/2
 */
@Mapper
public interface PayRecordMapper extends BaseMapper<PayRecordPo> {

}
