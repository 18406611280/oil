package com.grainoil.system.domain;

import com.grainoil.common.core.domain.BaseEntity;

public class TbRole extends BaseEntity {
    private static final long   serialVersionUID = 1L;
    /**
    * 角色id
    */
    private Long roleId;

    /**
    * 角色名
    */
    private String roleName;

    /**
    * 角色权限字符串
    */
    private String roleKey;

    /**
    * 显示顺序
    */
    private Long roleSort;

    /**
    * 组织类型数字字典
    */
    private String organizeType;

    /**
    * 删除标志（0代表存在 1代表删除）
    */
    private String delFlag;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    public Long getRoleSort() {
        return roleSort;
    }

    public void setRoleSort(Long roleSort) {
        this.roleSort = roleSort;
    }

    public String getOrganizeType() {
        return organizeType;
    }

    public void setOrganizeType(String organizeType) {
        this.organizeType = organizeType;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

}