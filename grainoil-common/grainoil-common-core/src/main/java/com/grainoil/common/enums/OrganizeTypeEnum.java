package com.grainoil.common.enums;

/**
 * @Author: chenminghong
 * @Date: 2021/5/13 17:24
 */
public enum OrganizeTypeEnum {

    CITY("1", "市粮管中心"),
    REGION("2", "区粮管部门"),
    BANK("3", "农发行"),
    QUALITY("4", "质检机构"),
    COMPANY("5", "承储企业");

    public String code;
    public String value;


    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    OrganizeTypeEnum(String code,String value) {
        this.code = code;
        this.value = value;
    }
}
