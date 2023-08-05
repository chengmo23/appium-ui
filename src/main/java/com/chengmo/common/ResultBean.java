package com.chengmo.common;

import lombok.Data;

/**
 * Create by chengmo at 2023/08/05
 */
@Data
public class ResultBean<T> {

    private long code;

    private String message;

    private T data;

    protected ResultBean() {
    }

    protected ResultBean(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResultBean<T> success() {
        return new ResultBean<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), null);
    }

    public static <T> ResultBean<T> success(T data) {
        return new ResultBean<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static <T> ResultBean<T> success(T data, String message) {
        return new ResultBean<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    public static <T> ResultBean<T> failed() {
        return failed(ResultCode.FAILED);
    }

    public static <T> ResultBean<T> failed(String message) {
        return new ResultBean<T>(ResultCode.FAILED.getCode(), message, null);
    }

    public static <T> ResultBean<T> failed(IErrorCode errorCode) {
        return new ResultBean<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    public static <T> ResultBean<T> failed(IErrorCode errorCode, String message) {
        return new ResultBean<T>(errorCode.getCode(), message, null);
    }
}
