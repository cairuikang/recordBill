package com.jhlc.record.core.exception;

import com.jhlc.record.controller.resp.ResultEnum;

/**
 * Created by staconfree on 2017/4/2.
 */
@SuppressWarnings("serial")
public class ParamException extends RuntimeException {

    private Integer errCode;

    public ParamException(String errMsg) {
        super(errMsg);
    }


    public ParamException(Integer errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
    }

    public ParamException(ResultEnum error) {
        super(error.getMsg());
        this.errCode = error.getCode();
    }

}
