package com.grainoil.common.enums;

/**
 * 存储类型
 *
 * @author song
 * @date create in 21/5/16 23:05
 */
public enum StoreTypeEnum {

    GRAINDEPOT("1", "粮库"),
    STOREHOUSE("2", "仓房"),
    PILE("3", "堆位");

    private String code;
    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    StoreTypeEnum(String code,String value) {
        this.code = code;
        this.value = value;
    }
}
