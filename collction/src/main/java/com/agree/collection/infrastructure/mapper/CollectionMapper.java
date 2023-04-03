package com.agree.collection.infrastructure.mapper;

import com.agree.collection.infrastructure.po.BillingRecordPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xulingfeng
 * @className BillingRecordMapper
 * @description
 * @date 2023/2
 */
@Mapper
public interface CollectionMapper extends BaseMapper<BillingRecordPO> {

}
