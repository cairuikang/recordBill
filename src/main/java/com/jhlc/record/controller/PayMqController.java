package com.jhlc.record.controller;

import com.jhlc.record.controller.resp.Result;
import com.jhlc.record.controller.resp.ResultUtils;
import com.jhlc.record.service.mq.ProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/mq/record")
@Slf4j
public class PayMqController {

    @Resource(name= "sendOrderIdServiceImpl")
    ProducerService producer;

    @ResponseBody
    @RequestMapping("/lcyPay")
    public Result pay(String orderId){
        producer.sendMsg(orderId);
        return ResultUtils.success();
    }


}
