package com.jhlc.record.controller.resp;

public enum ResultEnum {

    FAIL(100, "请求失败"),
    TIMEOUT(101, "请求超时"),

    SUCCESS(200, "成功"),
    UNLOGIN(201, "未登录"),
    ORDER_MISS_CODE(201,"没有该订单"),
    USER_MISS_CODE(211,"没有该用户"),

    EXCEPTION(300, "系统异常"),
    SQLEXCEPTION(301, "数据异常"),
    MAS_REQUEST_CODE(302,"该请求正在处理，请勿重复操作！");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
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
}