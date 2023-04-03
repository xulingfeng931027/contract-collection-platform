package com.agree.common.api;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * @author chenrui
 * @className AbstractIdObject
 * @description 实体唯一标识类
 * @date 2022/9/10
 */
@Data
@SuperBuilder
public abstract class AbstractPo<T> {
    @TableId(type = IdType.ASSIGN_ID)
    protected T id;
}
