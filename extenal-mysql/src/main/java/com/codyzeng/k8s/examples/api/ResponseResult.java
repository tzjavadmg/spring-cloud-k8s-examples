package com.codyzeng.k8s.examples.api;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * api返回结果对象<br>
 *
 */
@Getter
@Setter
public class ResponseResult<T> implements Serializable {

    private boolean success;
    private String code;
    private String message;
    private String detailMessage;
    private T data;

    private ResponseResult(boolean success) {
        this.success = success;
    }

    private ResponseResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    private ResponseResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    private ResponseResult(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    private ResponseResult(boolean success, String code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private ResponseResult(boolean success, String code, String message, String detailMessage, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.detailMessage = detailMessage;
        this.data = data;
    }

    static public <S> ResponseResult<S> ok() {
        return new ResponseResult<S>(true);
    }

    static public <S> ResponseResult<S> ok(String message) {
        return new ResponseResult<S>(true, message);
    }

    static public <S> ResponseResult<S> ok(S data) {
        return new ResponseResult<S>(true, data);
    }

    static public <S> ResponseResult<S> ok(String message, S data) {
        return new ResponseResult<S>(true, message, data);
    }

    static public <S> ResponseResult<S> ok(String code, String message, S data) {
        return new ResponseResult<S>(true, code, message, data);
    }

    static public <S> ResponseResult<S> ok(String code, String message, String detailMessage, S data) {
        return new ResponseResult<S>(true, code, message, detailMessage, data);
    }


    static public <S> ResponseResult<S> error() {
        return new ResponseResult<S>(false);
    }

    static public <S> ResponseResult<S> error(String message) {
        return new ResponseResult<S>(false, message);
    }

    static public <S> ResponseResult<S> error(String code, String message) {
        return new ResponseResult<S>(false, code, message, null);
    }

    static public <S> ResponseResult<S> error(String message, S data) {
        return new ResponseResult<S>(false, message, data);
    }

    static public <S> ResponseResult<S> error(String code, String message, S data) {
        return new ResponseResult<S>(false, code, message, data);
    }

    static public <S> ResponseResult<S> error(String code, String message, String detailMessage, S data) {
        return new ResponseResult<S>(false, code, message, detailMessage, data);
    }
}
