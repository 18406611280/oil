package com.grainoil.system.domain;

import com.grainoil.common.core.domain.BaseEntity;

public class TbUserRole extends BaseEntity {
    private static final long   serialVersionUID = 1L;
    /**
    * 主键id
    */
    private Long id;

    /**
    * 用户id
    */
    private Long userId;

    /**
    * 角色id
    */
    private Long roleId;

    /**
    * 删除标志（0代表存在 1代表删除）
    */
    private String delFlag;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

}