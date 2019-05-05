package com.jhlc.record.service.mq;

/**
 * @author 10096
 */
public interface ConsumerService {
    /**
     *
     * @param msg
     */
    void receive(String msg);
}
