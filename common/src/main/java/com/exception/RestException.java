package com.exception;

import lombok.Data;


@Data
public class RestException extends RuntimeException implements IBaseException {

    private String msg;
    private Integer ret;
    private Object data;

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public Integer getRet() {
        return ret;
    }

    public RestException(ErrorEnum errorEnum) {
        super(errorEnum.msg());
        this.msg = errorEnum.msg();
        this.ret = errorEnum.ret();
    }

    public static RestException of(String msg) {
        return new RestException(msg);
    }

    public static RestException of(ErrorEnum errorEnum) {
        return new RestException(errorEnum);
    }

    public RestException(String msg) {
        super(msg);
        this.msg = msg;
        this.ret = 500;

    }

    public RestException(int ret, String msg) {
        super(msg);
        this.msg = msg;
        this.ret = ret;
    }

    public RestException(int ret, String msg, Object data) {
        super(msg);
        this.msg = msg;
        this.ret = ret;
        this.data = data;
    }

}
