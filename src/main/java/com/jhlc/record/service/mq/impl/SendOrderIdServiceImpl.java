package com.jhlc.record.service.mq.impl;

import com.jhlc.record.core.mq.RabbitConsts;
import com.jhlc.record.service.mq.ProducerService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 10096
 */
@Service
public class SendOrderIdServiceImpl implements ProducerService {

    private @Autowired
    AmqpTemplate amqpTemplate;

    @Override
    public void sendMsg(String message) {
        amqpTemplate.convertAndSend(RabbitConsts.PAY_ORDER_IDS, message);
    }

}