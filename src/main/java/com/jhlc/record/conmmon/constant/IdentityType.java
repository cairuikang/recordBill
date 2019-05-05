package com.jhlc.record.conmmon.constant;

import lombok.Getter;

/**
 * @author 10096
 */

@Getter
public enum IdentityType {
    IDENTITY_TYPE1("渠道商", "1","c","C"),
    IDENTITY_TYPE2("会员", "2","u","E"),
    IDENTITY_TYPE3("组织", "3","b","B"),
    IDENTITY_TYPE4("组织下成员", "2","b-u","B-U");
    private String name;
    private String accountType;
    private String configType;
    private String gradeType;

    IdentityType(String name, String accountType, String configType, String gradeType) {
        this.name = name;
        this.accountType = accountType;
        this.configType = configType;
        this.gradeType = gradeType;
    }

    public static String getConfigTypeByAccountType(int accountType) {
        for (IdentityType c : IdentityType.values()) {
            if (c.getAccountType().equals(accountType)) {
                return c.configType;
            }
        }
        return null;
    }
    public static String getAccountTypeByConfigType(String configType) {
        for (IdentityType c : IdentityType.values()) {
            if (configType.equals(c.getConfigType()) ) {
                return c.accountType;
            }
        }
        return "0";
    }
    public static String getGradeTypeByConfigType(String configType) {
        for (IdentityType c : IdentityType.values()) {
            if (configType.equals(c.getConfigType()) ) {
                return c.gradeType;
            }
        }
        return null;
    }


}
