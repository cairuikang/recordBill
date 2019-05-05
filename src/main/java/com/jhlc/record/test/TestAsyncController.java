package com.jhlc.record.test;

import com.jhlc.record.controller.resp.Result;
import com.jhlc.record.controller.resp.ResultEnum;
import com.jhlc.record.controller.resp.ResultUtils;
import com.jhlc.record.service.PayService;
import com.jhlc.record.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

@RestController
@Slf4j
@RequestMapping("/test/async")
public class TestAsyncController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "/d/feiyanshi", method = RequestMethod.POST)
    @ResponseBody
    public DeferredResult<Result> deferredResultReq1 () {
        //设置超时时间60秒
        DeferredResult<Result> result = new DeferredResult<>(60*1000L);
        //处理超时事件 采用委托机制
        result.onTimeout(() -> {
            result.setResult(ResultUtils.error(ResultEnum.TIMEOUT));
        });
        testService.test1(result);
        result.onCompletion(() -> {
        });
        return result;
    }

    @RequestMapping(value = "/c/feiyanshi",method = RequestMethod.POST)
    public Callable<Result> getResult(){
        log.info("接收请求，开始处理...");
        Callable<Result> result = (()-> {
            testService.test2();
            return ResultUtils.success();
        }
        );
        log.info("接收任务线程完成并退出");
        return result;
    }


    @RequestMapping(value = "/d/yanshi", method = RequestMethod.POST)
    @ResponseBody
    public DeferredResult<Result> deferredResultReq () {
        //设置超时时间60秒
        DeferredResult<Result> result = new DeferredResult<>(60*1000L);
        //处理超时事件 采用委托机制
        result.onTimeout(() -> {
            result.setResult(ResultUtils.error(ResultEnum.TIMEOUT));
        });
        testService.timetest1(result);
        result.onCompletion(() -> {
        });
        return result;
    }

    @RequestMapping(value = "/c/yanshi",method = RequestMethod.POST)
    public Callable<Result> getResult1(){
        log.info("接收请求，开始处理...");
        Callable<Result> result = (()-> {
            testService.timeTest2();
            return ResultUtils.success();
        }
        );
        log.info("接收任务线程完成并退出");
        return result;
    }
}
