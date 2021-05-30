package com.grainoil.common.enums;

/**
 * 入库类型
 *
 * @author song
 * @date create in 21/5/17 10:21
 */
public enum InWarehouseTypeEnum {

    CALL_FOR_BID("1", "招标入库"),
    ROTATION("2", "轮换入库"),
    MOVING_THE_STOREHOUSE("3", "移库入库");

    private String code;
    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    InWarehouseTypeEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

}
