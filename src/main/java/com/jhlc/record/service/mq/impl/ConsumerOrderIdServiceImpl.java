package com.jhlc.record.service.mq.impl;

import com.jhlc.record.service.PayService;
import com.jhlc.record.service.mq.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 10096
 */
public class ConsumerOrderIdServiceImpl implements ConsumerService {

    @Autowired
    PayService payService;
    @Override
    public void receive(String msg) {
        payService.bookkeeping(Long.parseLong(msg),null);
    }
}
