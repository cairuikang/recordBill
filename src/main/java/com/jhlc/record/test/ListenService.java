package com.jhlc.record.test;

import com.jhlc.record.core.mq.RabbitConsts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ListenService {
    @RabbitListener(queues = {RabbitConsts.MESSAGE})
    public void a(){
      log.info("处理消息1");
    }
    @RabbitListener(queues = {RabbitConsts.MESSAGES})
    public void a2(){
        log.info("处理消息2");
    }
}
