package com.jhlc.record.core.exception;

import com.jhlc.record.controller.resp.ResultEnum;
import lombok.Data;

/**
 *
 * @author staconfree
 * @date 2017/4/2
 */
@Data
public class BizException extends RuntimeException {
    private Integer errCode;

    public BizException(String errMsg) {
        super(errMsg);
        this.errCode = ResultEnum.FAIL.getCode();
    }


    public BizException(Integer errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
    }

    public BizException(ResultEnum error) {
        super(error.getMsg());
        this.errCode = error.getCode();
    }
}
