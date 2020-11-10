package com.exception;

/**
 * 错误信息
 * 规则： ret<10000 为系统统一异常，由前端统一处理，
 * ret>10000 为业务异常，前端需要在业务代码中处理
 * 如：REPORT_PRODUCTING(6001, "报告生成中")由前端提示错误信息报告生成中
 *
 * @author hdj
 * @date 2018/11/11 15:09
 **/
public enum ErrorEnum {

    /**
     * 错误类型
     */
    ERROR(500, "网络出错"),
    NOT_FOUND(404, "找不到数据"),
    SC_FORBIDDEN(403, "你没有该权限"),
    SC_UNAUTHORIZED(401, "您不允许访问该资源，请重新登录"),
    NOT_LOGIN(201, "未登录，请登录"),
    AGAIN_LOGIN(203, "请重新登录"),
    CANNOT_LOGIN(204, "您的账号已被删除，不可再使用"),
    ILLEGAL_USER(205, "非法用户，不能操作"),
    SUCCESS(0, "请求成功"),

    CLOSE_OR_RETURN(10086, "关闭当前页面,返回上一页面"),

    RB_CLOSE_LENDING(10087, "已关闭团队人保进件放款"),

    POPUP_WINDOW(10000, "弹窗"),
    RE_LOGIN(500, "账号被强制下线"),
    REPORT_PRODUCTING(6001, "报告生成中");


    private final Integer ret;

    private final String msg;

    public int ret() {
        return ret;
    }

    public String msg() {
        return msg;
    }

    ErrorEnum(Integer ret, String msg) {
        this.ret = ret;
        this.msg = msg;
    }
}
