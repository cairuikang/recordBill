package com.jhlc.record.core.advice;

import com.jhlc.record.controller.resp.Result;
import com.jhlc.record.controller.resp.ResultEnum;
import com.jhlc.record.controller.resp.ResultUtils;
import com.jhlc.record.core.exception.BizException;
import com.jhlc.record.core.exception.SqlException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 10096
 */
@ControllerAdvice
public class MyExceptionAdvice {


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result defaultException(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        return ResultUtils.error(ResultEnum.EXCEPTION);

    }


    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public Result bizException(HttpServletRequest request, BizException e) {
        e.printStackTrace();
        Integer code = e.getErrCode();
        String message = e.getMessage();
        if (e.getErrCode() == null) {
            code = ResultEnum.EXCEPTION.getCode();
        }
        if (e.getMessage() == null) {
            message = ResultEnum.EXCEPTION.getMsg();
        }
        return ResultUtils.error(code,message);
    }

    @ExceptionHandler(value = SqlException.class)
    @ResponseBody
    public Result sqlException(HttpServletRequest request, BizException e) {
        e.printStackTrace();
        Integer code = e.getErrCode();
        String message = e.getMessage();
        if (e.getErrCode() == null) {
            code = ResultEnum.SQLEXCEPTION.getCode();
        }
        if (e.getMessage() == null) {
            message = ResultEnum.SQLEXCEPTION.getMsg();
        }
        return ResultUtils.error(code,message);
    }

}
