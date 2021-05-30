package com.grainoil.common.enums;

/**
 * 角色
 *
 * @author song
 * @date create in 21/5/17 0:27
 */
public enum RoleEnum {

    COMPANY_STOREHOUSE_PRINCIPAL("1", "仓库保管员"),
    COMPANY_GRAINDEPOT_PRINCIPAL("2", "粮库负责人"),
    COMPANY_IN_OUT_PRINCIPAL("3", "出入仓单管理员"),
    COMPANY_CHECKER("4", "企业质检员"),
    COMPANY_FINANCE("5", "财务人员"),
    COMPANY_OPERATOR("6", "运营人员"),
    COMPANY_LEADER("7", "企业负责人"),
    QUALITY_OPERATOR("8", "穗粮经办人"),
    REGION_OPERATOR("9", "区粮管部门经办人"),
    REGION_AUDITOR("10", "区粮管部门审核人"),
    CITY_OPERATOR("11", "市粮管中心经办人"),
    CITY_PRINCIPAL("12", "市粮管中心业务负责人"),
    CITY_LEADER("13", "市粮管中心领导"),
    BANK_OFFICER("14", "农发行信贷员"),
    BANK_PRINCIPAL("15", "农发行主管");

    private String code;
    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    RoleEnum(String code,String value) {
        this.code = code;
        this.value = value;
    }
}
