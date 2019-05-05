package com.jhlc.record.test;

import com.jhlc.record.core.mq.RabbitConsts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * 生产者
 * @author milicool
 * Created on 2018/9/14
 */
@Component
@RestController
@RequestMapping("/ack")
@Slf4j
public class Producer {

    @Resource(name="ackRabbitTemplate")
    private RabbitTemplate rabbitTemplate;

    /**
     * 给hello队列发送消息
     */
    @RequestMapping("/send")
    public void send() {
        String msg = "ack测试消息";
        log.info("发送消息：" + msg);
        rabbitTemplate.convertAndSend(RabbitConsts.ACKQUEUE,msg);
    }

}