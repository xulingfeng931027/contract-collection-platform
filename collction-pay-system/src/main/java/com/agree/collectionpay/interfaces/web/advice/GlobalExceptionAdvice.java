package com.agree.collectionpay.interfaces.web.advice;

import com.agree.common.exception.BaseException;
import com.agree.common.web.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * mvc统一异常处理类
 *
 * @author xulingfeng
 * 
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {

    /**
     * 业务异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BaseException.class)
    public Response applicationException(BaseException e) {
        log.info("applicationException: [{},{}]", e.getCode(), e.getDescription(), e);
        log.info("stackTrace: {}", e.getStackTrace()[0]);
        return new Response<>(e.getDescription(), e.getCode());
    }


    /**
     * 未知错误(未捕获的异常情况)
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Response baseErrorHandler(HttpServletRequest req, HttpServletResponse rsp, Exception e) {
        log.error("baseErrorHandler [ HOST:{} URL:{} STATUS:{}] ", req.getRemoteHost(), req.getRequestURL(), rsp.getStatus(), e);
        rsp.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new Response("UNKNOWN_EXCEPTION", -1);
    }

    /**
     * 入参校验失败
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response paramErrorHandler(HttpServletRequest req, HttpServletResponse rsp, MethodArgumentNotValidException e) {
        log.error("baseErrorHandler [ HOST:{} URL:{} STATUS:{}] ", req.getRemoteHost(), req.getRequestURL(), rsp.getStatus(), e);
        rsp.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        Response response = new Response(e.getMessage(), -1);
        response.setMsg(e.getMessage());
        return response;
    }
}
