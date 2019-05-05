package com.jhlc.record.controller;

import com.jhlc.record.controller.resp.Result;
import com.jhlc.record.controller.resp.ResultUtils;
import com.jhlc.record.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 10096
 */
@Controller
@RequestMapping("/record")
@Slf4j
public class PayController {

    @Autowired
    PayService payService;

    @ResponseBody
    @RequestMapping("/lcyPay")
    public Result pay(Long orderId){
        payService.bookkeeping(orderId,null);
        return ResultUtils.success();
    }


}
