package com.jhlc.record.test;

import com.jhlc.record.controller.resp.Result;
import com.jhlc.record.controller.resp.ResultUtils;
import com.jhlc.record.service.PayService;
import com.jhlc.record.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    TestService testService;

    @ResponseBody
    @RequestMapping("/feiyanshi")
    public Result pay1(){
        testService.getResult();
        return ResultUtils.success();
    }

    @ResponseBody
    @RequestMapping("/yanshi")
    public Result pay2(){
        testService.getTimeResult();
        return ResultUtils.success();
    }


}
