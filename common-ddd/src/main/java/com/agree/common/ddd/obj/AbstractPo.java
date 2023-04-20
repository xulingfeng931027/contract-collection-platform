package com.agree.common.ddd.obj;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * @author xulingfeng
 * @description po标识类
 */
@Data
@SuperBuilder
public abstract class AbstractPo<T> {
    @TableId(type = IdType.ASSIGN_ID)
    protected T id;

    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}
