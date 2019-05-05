package com.jhlc.record.core.mq;

public interface RabbitConsts {
    /**
     * 普通模式队列，支付消息队列
     */
    String PAY_ORDER_IDS = "payOrderIds";
    /**
     * 订阅模式队列：只接一个topic
     */
    String MESSAGE = "topic.message";
    /**
     *订阅模式队列：接收多个topic
     */
    String MESSAGES = "topic.messages";

    /**
     *订阅模式队列：接收多个topic
     */
    String USERLOG = "log.user.queue.name";

    /**
     * ack机制队列
     */
    String ACKQUEUE = "ackqueue";
}
