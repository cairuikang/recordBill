package com.jhlc.record.core.mq.rabbitmq;

import com.jhlc.record.core.mq.RabbitConsts;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @Author:linyuanhuang
 * @Description:Topic Exchange配置类
 * @Date:2017/12/11 17:13
 */
@Configuration
public class RabbitMqDirectConfig {

    @Autowired
    private Environment env;

    @Bean
    public Queue directMessage() {
        return new Queue(env.getProperty("log.user.queue.name"));
    }

    @Bean("directExchange")
    DirectExchange directExchange() {
        return new DirectExchange(env.getProperty("log.user.exchange.name"),true,false);
    }

    @Bean
    Binding bindingDirectExchangeMessages(Queue directMessage, TopicExchange directExchange) {
        return BindingBuilder.bind(directMessage).to(directExchange).with(env.getProperty("log.user.routing.key.name"));
    }
}