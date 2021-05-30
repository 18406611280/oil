package com.grainoil.system.domain;

import com.grainoil.common.core.domain.BaseEntity;
import com.grainoil.common.utils.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TbMenu extends BaseEntity {

    private static final long   serialVersionUID = 1L;
    /**
    * 菜单ID
    */
    private Long menuId;

    /**
    * 菜单名称
    */
    private String menuName;

    /**
    * 菜单标识
    */
    private String menuKey;

    /**
    * 菜单布局
    */
    private String component;

    /**
    * 父菜单ID
    */
    private Long parentId;

    /**
    * 打开方式
    */
    private String target;

    /**
    * 显示顺序
    */
    private Long orderNum;

    /**
    * 菜单类型（M目录 C菜单 F按钮）
    */
    private String menuType;

    /**
    * 菜单状态（0显示 1隐藏）
    */
    private String visible;

    /**
    * 权限标识
    */
    private String perms;

    /**
    * 菜单图标
    */
    private String icon;

    /**
    * 链接
    */
    private String path;

    /**
    * 重定向
    */
    private String redirect;

    /**
    * 强制菜单显示为Item而不是SubItem
    */
    private String hiddenChildren;

    /**
    * 特殊 隐藏 PageHeader 组件中的页面带的 面包屑和页面标题栏
    */
    private Boolean hiddenHeader;

    public static Map<String, Object> getMap(TbMenu menu) {
        Map<String, Object> map = new HashMap<>();
        map.put("key", menu.getMenuId());
        map.put("name", menu.getMenuKey());
        map.put("path", menu.getPath());
        map.put("orderNum", menu.getOrderNum());
        if (StringUtils.isNotBlank(menu.getRedirect())) {
            map.put("redirect", menu.getRedirect());
        }
        map.put("component", menu.getComponent());
        if ("0".equals(menu.getHiddenChildren())) {
            map.put("hideChildrenInMenu", true);
        } else if ("1".equals(menu.getHiddenChildren())) {
            map.put("hideChildrenInMenu", false);
        }
        Map<String, Object> meta = new HashMap<>();
        if (StringUtils.isNotBlank(menu.getIcon())) {
            meta.put("icon", menu.getIcon());
        }
        meta.put("keepAlive", true);
        meta.put("title", menu.getMenuName());
        map.put("meta", meta);
        return map;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuKey() {
        return menuKey;
    }

    public void setMenuKey(String menuKey) {
        this.menuKey = menuKey;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public String getHiddenChildren() {
        return hiddenChildren;
    }

    public void setHiddenChildren(String hiddenChildren) {
        this.hiddenChildren = hiddenChildren;
    }

    public Boolean getHiddenHeader() {
        return hiddenHeader;
    }

    public void setHiddenHeader(Boolean hiddenHeader) {
        this.hiddenHeader = hiddenHeader;
    }

}