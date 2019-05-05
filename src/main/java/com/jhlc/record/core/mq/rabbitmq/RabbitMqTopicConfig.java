package com.jhlc.record.core.mq.rabbitmq;

import com.jhlc.record.core.mq.RabbitConsts;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:linyuanhuang
 * @Description:Topic Exchange配置类
 * @Date:2017/12/11 17:13
 */
@Configuration
public class RabbitMqTopicConfig {


    @Bean
    public Queue queueTopicMessage() {
        return new Queue(RabbitConsts.MESSAGE);
    }

    @Bean
    public Queue queueTopicMessages() {
        return new Queue(RabbitConsts.MESSAGES);
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    Binding bindingExchangeMessage(Queue queueTopicMessage, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueTopicMessage).to(topicExchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueTopicMessages, TopicExchange topicExchange) {
        //这里的#表示零个或多个词。
        return BindingBuilder.bind(queueTopicMessages).to(topicExchange).with("topic.#");
    }
}