package com.grainoil.common.enums;


/**
 * 质检类型
 * @Author: chenminghong
 * @Date: 2021/5/12 15:12
 */
public enum QualityTypeEnum {

    ALL("0", "全部"),
    IN("1", "入库质检"),
    DAY("2", "日常质检"),
    OUT("3", "出库质检"),
    DELAYED("4", "延期储存质检");

    public String code;
    public String value;


    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    QualityTypeEnum(String code,String value) {
        this.code = code;
        this.value = value;
    }




}
