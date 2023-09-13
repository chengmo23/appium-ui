package com.chengmo.common;

import lombok.Data;

/**
 * Create by chengmo at 2023/08/05
 */
@Data
public class ResultBean {

    private long code;

    private String message;

    private Object data;

    protected ResultBean() {
    }

    protected ResultBean(long code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResultBean success() {
        return new ResultBean(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), null);
    }

    public static ResultBean success(Object data) {
        return new ResultBean(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static ResultBean success(Object data, String message) {
        return new ResultBean(ResultCode.SUCCESS.getCode(), message, data);
    }

    public static ResultBean failed() {
        return failed(ResultCode.FAILED);
    }

    public static ResultBean failed(String message) {
        return new ResultBean(ResultCode.FAILED.getCode(), message, null);
    }

    public static ResultBean failed(ResultCode errorCode) {
        return new ResultBean(errorCode.getCode(), errorCode.getMessage(), null);
    }

    public static ResultBean failed(ResultCode errorCode, String message) {
        return new ResultBean(errorCode.getCode(), message, null);
    }
}
