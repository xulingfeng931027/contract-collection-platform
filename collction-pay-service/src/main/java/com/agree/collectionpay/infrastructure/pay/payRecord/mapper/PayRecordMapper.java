package com.agree.collectionpay.infrastructure.pay.payRecord.mapper;

import com.agree.collectionpay.infrastructure.pay.payRecord.po.PayRecordPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xulingfeng
 * @className BillingRecordMapper
 * @description
 * 
 */
@Mapper
public interface PayRecordMapper extends BaseMapper<PayRecordPo> {

}
