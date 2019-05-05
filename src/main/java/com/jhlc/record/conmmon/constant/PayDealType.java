package com.jhlc.record.conmmon.constant;

import lombok.Getter;

/**
 * @author 10096
 */

@Getter
public enum PayDealType {
    DEAL_TYPE1("充值", "1"),
    DEAL_TYPE11("充值在途金额", "11"),
    DEAL_TYPE2("余额扣款", "2"),
    DEAL_TYPE21("扣除在途金额", "21"),
    DEAL_TYPE3("转账", "3"),
    DEAL_TYPE4("佣金入账", "4"),
    DEAL_TYPE5("返佣-冻结", "5"),
    DEAL_TYPE6("", "6"),
    DEAL_TYPE7("提现-冻结", "7"),
    DEAL_TYPE8("提现-完成", "8");
    private String name;
    private String index;

    PayDealType(String name, String index) {
        this.name = name;
        this.index = index;
    }

    public static String getNameByIndex(String index) {
        for (PayDealType c : PayDealType.values()) {
            if (c.getIndex().equals(index)) {
                return c.name;
            }
        }
        return "";
    }

    public static PayDealType getPDTByIndex(String index) {
        for (PayDealType c : PayDealType.values()) {
            if (c.getIndex().equals(index)) {
                return c;
            }
        }
        return null;
    }

}
