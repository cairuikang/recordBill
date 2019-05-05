package com.jhlc.record.core.exception;

import com.jhlc.record.controller.resp.ResultEnum;
import lombok.Data;

/**
 * Created by staconfree on 2017/4/2.
 */
@Data
public class SqlException extends RuntimeException {
    private Integer errCode;

    public SqlException(String errMsg) {
        super(errMsg);
    }


    public SqlException(Integer errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
    }

    public SqlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.errCode = resultEnum.getCode();
    }
}
