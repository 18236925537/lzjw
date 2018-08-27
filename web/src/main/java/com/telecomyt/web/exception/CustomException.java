package com.telecomyt.web.exception;

import com.telecomyt.web.enums.ResultStatus;

/**
 * @ProjectName: web
 * @ClassName: CustomException
 * @Description: 自定义异常
 * @Author: dianxinyitong
 * @modified:
 * @Date: 2018/7/27 15:58
 */
public class CustomException extends RuntimeException{


    private Integer code;
    private String msg;

    /**
     * 继承exception，加入错误状态值
     * @param resultStatus
     */
    public CustomException(ResultStatus resultStatus) {
        super(resultStatus.getErrorMsg());
        this.code = resultStatus.getErrorCode();
    }

    /**
     * 自定义错误信息
     * @param message
     * @param code
     */
    public CustomException(Integer code,String message) {
        this.msg = message;
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
