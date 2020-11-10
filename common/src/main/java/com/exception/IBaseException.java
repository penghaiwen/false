package com.exception;


public interface IBaseException {

    /**
     * 获取错误信息
     *
     * @return 错误信息
     */
    String getMsg();

    /**
     * 获取错误码
     *
     * @return 0，200，500
     */
    Integer getRet();

}
