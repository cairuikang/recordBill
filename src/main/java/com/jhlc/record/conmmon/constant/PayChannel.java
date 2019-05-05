package com.jhlc.record.conmmon.constant;

import lombok.Getter;

/**
 * @author 10096
 */
@Getter
public enum PayChannel {
    /**
     * 余额支付
     */
    USER_TYPE1("余额支付", "1");


    private String name;
    private String channelId;

    PayChannel(String name, String channelId) {
        this.name = name;
        this.channelId = channelId;
    }

    public static String getNameByIndex(String channelId) {
        for (PayChannel c : PayChannel.values()) {
            if (c.getChannelId() == channelId) {
                return c.name;
            }
        }
        return "";
    }
    public static PayChannel getByIndex(String channelId) {
        for (PayChannel c : PayChannel.values()) {
            if (c.getChannelId() == channelId) {
                return c;
            }
        }
        return null;
    }

}
