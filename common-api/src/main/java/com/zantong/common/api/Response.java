package com.zantong.common.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response<T> {

    private Status status;
    private String msg;
    private T data;


    public static Response<?> ok() {
        return Response.builder().status(Status.SUCCESS).build();
    }

    public static <T> Response<T> ok(T data) {
        return (Response<T>) Response.builder().status(Status.SUCCESS).data(data).build();
    }

    public static Response<?> failed(String msg) {
        return Response.builder().status(Status.FAILED).msg(msg).build();
    }

    public enum Status {
        SUCCESS, FAILED
    }
}
