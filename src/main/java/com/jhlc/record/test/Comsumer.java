package com.jhlc.record.test;

import com.jhlc.record.core.mq.RabbitConsts;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 消费者
 * @author milicool
 * Created on 2018/9/14
 */
@Component
@Slf4j
public class Comsumer {

    @RabbitListener(queues = RabbitConsts.ACKQUEUE)
    public void process(String msg,Message message, Channel channel) throws IOException {
        // 采用手动应答模式, 手动确认应答更为安全稳定
        log.info("接收到的消息: " + msg);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
    }
}