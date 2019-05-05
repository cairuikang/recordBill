package com.jhlc.record.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class SendController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping("/topicSend1")
    public String  topicSend1() {
        String context = "my topic 1";
        log.info("发送者说 : " + context);
        this.amqpTemplate.convertAndSend("testexchange", "topic.message", context);
        return context;
    }

    @RequestMapping("/topicSend2")
    public String topicSend2() {
        String context = "my topic 2";
        log.info("发送者说 : " + context);
        this.amqpTemplate.convertAndSend("testexchange", "topic.messages", context);
        return  context;
    }

}