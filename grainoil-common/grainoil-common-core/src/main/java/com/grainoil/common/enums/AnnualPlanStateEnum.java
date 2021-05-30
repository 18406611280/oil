package com.grainoil.common.enums;

/**
 * 年度轮换计划状态
 *
 * @author song
 * @date create in 21/5/24 3:47
 */
public enum AnnualPlanStateEnum {

    DRAFT("1", "草稿"),
    APPROVAL_PENDING("2", "待审批"),
    NOT_GO("5", "审批不通过"),
    RUNNING("3", "执行中"),
    COMPLETED("4", "已完成");

    private String code;
    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    AnnualPlanStateEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }
}
