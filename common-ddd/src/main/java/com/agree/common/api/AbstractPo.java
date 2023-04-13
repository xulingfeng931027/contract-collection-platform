package com.agree.common.api;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * @author xulingfeng
 * @description po标识类
 * 
 */
@Data
@SuperBuilder
public abstract class AbstractPo<T> {
    @TableId(type = IdType.ASSIGN_ID)
    protected T id;
}
