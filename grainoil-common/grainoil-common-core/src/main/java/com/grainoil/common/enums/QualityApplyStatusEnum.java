package com.grainoil.common.enums;

/**
 * 质检申请状态
 * @Author: chenminghong
 * @Date: 2021/5/17 14:45
 */
public enum  QualityApplyStatusEnum {

    DRAFT("0", "草稿"),
    PENDING_APPROVAL("1", "待审批"),
    NO_PASS("2", "审批不通过"),
    TO_BE_RECEIVED("3", "待接收"),
    TO_BE_SAMPLE("4", "待扦样"),
    SAMPLE("5", "已扦样"),
    WITHDRAWN("6", "已撤回"),
    COMPLETED("7", "已完成");

    public String code;
    public String value;


    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    QualityApplyStatusEnum(String code,String value) {
        this.code = code;
        this.value = value;
    }

    public static QualityApplyStatusEnum getByCode(String code){
        QualityApplyStatusEnum[] values = QualityApplyStatusEnum.values();
        for (QualityApplyStatusEnum value : values) {
            if(value.code.equals(code)){
                return value;
            }
        }
        return null;
    }

}
