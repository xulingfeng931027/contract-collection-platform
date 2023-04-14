package com.agree.common.ddd.obj;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @author xulingfeng
 * @description 聚合根对象基类
 * 
 */
@Getter
@SuperBuilder
public abstract class AbstractAggregationObject<T> extends AbstractEntityObject<T> {
}
