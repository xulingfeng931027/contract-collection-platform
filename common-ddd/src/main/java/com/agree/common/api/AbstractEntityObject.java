package com.agree.common.api;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @author xulingfeng
 * @description 实体对象基类
 * 
 */
@Getter
@SuperBuilder
public abstract class AbstractEntityObject<T> implements DomainObject {

    protected T id;
}
