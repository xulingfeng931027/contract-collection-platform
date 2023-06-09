package com.agree.common.ddd.web;

import com.agree.common.ddd.exception.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author xulingfeng
 * @description 基础接口返回结构
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response<T> {

    public static final int SUCCESS = 200;
    private String msg;
    private T data;
    public static final int FAILED = -1;
    private Integer code;


    public Response(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }

    public Response(BaseErrorCode baseErrorCode) {
        this.code = baseErrorCode.getCode();
        this.msg = baseErrorCode.getDescription();
    }

    public static Response<?> ok() {
        return Response.builder().code(SUCCESS).build();
    }

    public static <T> Response<T> ok(T data) {
        return (Response<T>) Response.builder().code(SUCCESS).data(data).build();
    }

    public static Response<?> failed(String msg) {
        return Response.builder().code(FAILED).msg(msg).build();
    }

}
