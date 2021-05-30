package com.grainoil.common.enums;

/**
 * 出入仓类型
 * @author song
 * @date create in 21/5/24 3:43
 */
public enum InOrOutEnum {

    OUT("1", "出仓"),
    IN("2", "入仓");

    private String code;
    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    InOrOutEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }
}
