package com.jhlc.record.controller.resp;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ResultUtils {

    private static Integer SUCCESS_CODE = 200;
    private static Integer ERROR_CODE = 999;

    public static Result success(Integer code, String msg, Object data) {
        log.info("返回code:{}；提示信息:{}；数据:{}", code, msg, data);
        return Result.builder()
                .msg(msg)
                .code(code)
                .data(data)
                .build();
    }
    public static Result success() {
        return success(ResultEnum.SUCCESS);
    }
    public static Result success(ResultEnum resultEnum) {
        return success(resultEnum.getCode(), resultEnum.getMsg(), null);
    }

    public static Result success(ResultEnum resultEnum, Object data) {
        return success(resultEnum.getCode(), resultEnum.getMsg(), data);
    }

    public static Result success(String msg) {
        return success(SUCCESS_CODE, msg, null);
    }

    public static Result success(Integer code, String msg) {
        return success(code, msg, null);
    }

    public static Result success(String msg, Object data) {
        return success(SUCCESS_CODE, msg, data);
    }


    public static Result error(Integer code, String msg, Object data) {
        log.info("异常返回：{}；提示信息{}；数据:{}", code, msg, data);
        return Result.builder()
                .msg(msg)
                .code(code)
                .data(data)
                .build();
    }

    public static Result error(ResultEnum resultEnum) {
        return error(resultEnum.getCode(), resultEnum.getMsg(), null);
    }

    public static Result error(ResultEnum resultEnum, Object data) {
        return error(resultEnum.getCode(), resultEnum.getMsg(), data);
    }

    public static Result error(String msg) {
        return error(ERROR_CODE, msg, null);
    }

    public static Result error(Integer code, String msg) {
        return error(code, msg, null);
    }

    public static Result error(String msg, Object data) {
        return error(ERROR_CODE, msg, data);
    }
}
