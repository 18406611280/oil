package com.grainoil.common.enums;

/**
 * 入库状态
 *
 * @author song
 * @date create in 21/5/17 10:29
 */
public enum ImportStateEnum {
    DRAFT("1", "草稿"),
    APPROVAL_PENDING("2", "待审批"),
    NOT_GO("3", "不通过"),
    RUNNING("6", "执行中"),
    COMPLETED("7", "已完成");

    private String code;
    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    ImportStateEnum(String code,String value) {
        this.code = code;
        this.value = value;
    }
}
