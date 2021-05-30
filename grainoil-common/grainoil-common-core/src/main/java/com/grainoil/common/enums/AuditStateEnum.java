package com.grainoil.common.enums;

/**
 * 审核状态
 *
 * @author song
 * @date create in 21/5/24 4:10
 */
public enum AuditStateEnum {

    WAIT("1", "待审核"),
    COMPLETE("2", "已审核"),
    WRONG("3", "数据有误");

    private String code;
    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    AuditStateEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }
}
