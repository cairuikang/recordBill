package com.jhlc.record.service;

import com.jhlc.record.controller.resp.Result;
import com.jhlc.record.controller.resp.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

@Service
@Slf4j
public class TestService {

    @Async("myTaskAsyncPool")
    public void test1(DeferredResult<Result> result){
        log.info("内部线程:{}",Thread.currentThread().getName());
        result.setResult(ResultUtils.success());
    }
    @Async("myTaskAsyncPool")
    public void test2(){
        log.info("调用完成内部线程:{}",Thread.currentThread().getName());
    }

    @Async("myTaskAsyncPool")
    public void timetest1(DeferredResult<Result> result) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("内部线程:{}",Thread.currentThread().getName());
        result.setResult(ResultUtils.success());
    }
    @Async("myTaskAsyncPool")
    public void timeTest2(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("调用完成内部线程:{}",Thread.currentThread().getName());
    }

    public Result getTimeResult(){
        log.info("任务开始执行，持续等待中...");
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("任务处理完成");
        return ResultUtils.success();
    }
    public Result getResult(){
        log.info("任务开始执行，持续等待中...");
        log.info("任务处理完成");
        return ResultUtils.success();
    }
}
