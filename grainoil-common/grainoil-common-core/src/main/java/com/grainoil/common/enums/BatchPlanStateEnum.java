package com.grainoil.common.enums;

/**
 * 日常轮换计划状态
 *
 * @author song
 * @date create in 21/5/24 3:45
 */
public enum BatchPlanStateEnum {

    DRAFT("1", "草稿"),
    APPLY_APPROVE("2", "申请待审批"),
    APPROVAL_COMPLETE("3", "已审批"),
    ROTATE("4", "轮换中"),
    CHANGE_APPROVE("5", "变更待审批"),
    STOP_APPROVE("6", "终止待审批"),
    NOT_GO("7", "审批不通过"),
    COMPLETED("8", "已完成"),
    STOP("9", "已终止");

    private String code;
    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    BatchPlanStateEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }
}
