package com.jhlc.record.service.mq;

import com.jhlc.record.core.mq.RabbitConsts;
import com.jhlc.record.service.PayService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@NoArgsConstructor
public class ListenerServiceConsumer {
    @Autowired

    private PayService payService;


    @RabbitListener(queues = {RabbitConsts.PAY_ORDER_IDS})
    public void receiveSmsCodeQueue(String message) {
        log.info("消息处理1_支付订单_入参orderId:{}",message);
        payService.bookkeeping(Long.parseLong(message),null);
    }

}