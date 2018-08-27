package com.telecomyt.web.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 返回信息实体类
 * @param <T>
 */
@ApiModel("服务器返回信息")
public class BaseResp<T> {
    /**
     * 返回码
     */
    @ApiModelProperty(value="服务器响应码，200为成功，其他失败",name="code")
    private int code;

    /**
     * 返回信息描述
     */
    @ApiModelProperty(value="服务器响应信息",name="message")
    private String message;

    /**
     * 返回数据
     */
    @ApiModelProperty(value="服务器返回数据",name="data")
    private T data;
    @ApiModelProperty(value="服务器响时间",name="currentTime")
    private long currentTime;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    public BaseResp(){}

    /**
     *
     * @param code 错误码
     * @param message 信息
     * @param data 数据
     */
    public BaseResp(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.currentTime = new Date().getTime();
    }

    /**
     * 不带数据的返回结果
     * @param resultStatus
     */
    public BaseResp(ResultStatus resultStatus) {
        this.code = resultStatus.getErrorCode();
        this.message = resultStatus.getErrorMsg();
        this.data = data;
        this.currentTime = new Date().getTime();
    }

    /**
     * 带数据的返回结果
     * @param resultStatus
     * @param data
     */
    public BaseResp(ResultStatus resultStatus, T data) {
        this.code = resultStatus.getErrorCode();
        this.message = resultStatus.getErrorMsg();
        this.data = data;
        this.currentTime = new Date().getTime();
    }


}

