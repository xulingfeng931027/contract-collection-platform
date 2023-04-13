package com.agree.common.api;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @author xulingfeng
 * @description 聚合根对象基类
 * @date 2023/3/1
 */
@Getter
@SuperBuilder
public abstract class AbstractAggregationObject<T> extends AbstractEntityObject<T> {
}
