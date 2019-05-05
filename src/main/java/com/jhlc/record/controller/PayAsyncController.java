package com.jhlc.record.controller;

import com.jhlc.record.controller.resp.Result;
import com.jhlc.record.controller.resp.ResultEnum;
import com.jhlc.record.controller.resp.ResultUtils;
import com.jhlc.record.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;


/**
 * @author 10096
 */
@RestController
@Slf4j
@RequestMapping("/async/record")
public class PayAsyncController {

    @Autowired
    PayService payService;

    @RequestMapping(value = "/lcyPay", method = RequestMethod.POST)
    @ResponseBody
    public DeferredResult<Result> deferredResultReq (String orderId) {
        log.info("外部线程：{}" , Thread.currentThread().getName());
        //设置超时时间60秒
        DeferredResult<Result> result = new DeferredResult<>(60*1000L);
        //处理超时事件 采用委托机制
        result.onTimeout(() -> {
            log.info("DeferredResult超时");
            result.setResult(ResultUtils.error(ResultEnum.TIMEOUT));
        });
        payService.asyncBookkeeping(Long.parseLong(orderId),null,result);
        result.onCompletion(() -> {
            //完成后
            log.info("接口调用完成");
        });
        return result;
    }

    @RequestMapping(value = "/callable",method = RequestMethod.POST)
    public Callable<Result> getResult(String orderId){
        log.info("接收请求，开始处理...");
        Callable<Result> result = (()-> {
            payService.bookkeeping(Long.parseLong(orderId), null);
            return ResultUtils.success();
        }
        );
        log.info("接收任务线程完成并退出");
        return result;
    }
}
