package com.grainoil.system.domain;

import com.grainoil.common.core.domain.BaseEntity;

public class TbRoleMenu extends BaseEntity {
    private static final long   serialVersionUID = 1L;
    /**
    * id
    */
    private Long id;

    /**
    * 角色id
    */
    private Long roleId;

    /**
    * 菜单id
    */
    private Long menuId;

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

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

}