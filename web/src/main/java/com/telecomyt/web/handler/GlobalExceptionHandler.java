package com.telecomyt.web.handler;

import com.telecomyt.web.exception.CustomException;
import com.telecomyt.web.result.BaseResp;
import com.telecomyt.web.result.ResultStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 */
@ControllerAdvice(annotations = {Controller.class})
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 系统异常处理，比如：404,500
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResp<?> defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        logger.info(""+e.getMessage());
        BaseResp baseResp = new BaseResp();
        if (e instanceof CustomException) {
            baseResp.setCode(((CustomException) e).getCode());
            baseResp.setMessage(((CustomException) e).getMsg());
        } else {
            baseResp.setMessage(ResultStatus.http_status_internal_server_error.getErrorMsg());
            baseResp.setCode(ResultStatus.http_status_internal_server_error.getErrorCode());
        }
        baseResp.setData("");
        return baseResp;
    }

}
