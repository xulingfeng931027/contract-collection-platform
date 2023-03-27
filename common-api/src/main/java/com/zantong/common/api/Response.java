package com.zantong.common.api;

import com.zantong.common.exception.AppCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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


    public Response(AppCode appCode) {
        this.code = appCode.getCode();
        this.msg = appCode.getDescription();
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
