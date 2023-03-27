package com.zantong.common.exception;

import com.zantong.common.api.Response;
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
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 应用异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ApplicationException.class)
    public Response applicationException(ApplicationException e) {
        log.info("applicationException: [{},{}]", e.getAppCode().getCode(), e.getAppCode().getDescription(), e);
        log.info("stackTrace: {}", e.getStackTrace()[0]);
        return new Response<>(e.getAppCode());
    }


    /**
     * 未知错误(未捕获的异常情况)，状态500
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Response baseErrorHandler(HttpServletRequest req, HttpServletResponse rsp, Exception e) {
        log.error("baseErrorHandler [ HOST:{} URL:{} STATUS:{}] ", req.getRemoteHost(), req.getRequestURL(), rsp.getStatus(), e);
        rsp.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new Response(BaseAppCode.UNKNOWN_EXCEPTION);
    }

    /**
     * 未知错误(未捕获的异常情况)，状态500
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response paramErrorHandler(HttpServletRequest req, HttpServletResponse rsp, Exception e) {
        log.error("baseErrorHandler [ HOST:{} URL:{} STATUS:{}] ", req.getRemoteHost(), req.getRequestURL(), rsp.getStatus(), e);
        rsp.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        Response response = new Response(BaseAppCode.PARAM_CHECK_FAILED);
        response.setMsg(e.getMessage());
        return response;
    }
}
