package com.grainoil.system.mapper;

import com.grainoil.system.domain.TbMenu;
import com.grainoil.system.domain.TbRole;

import java.util.List;

public interface TbMenuMapper {

    TbMenu selectByPrimaryKey(Long menuId);

    /**
     * 根据角色查询菜单权限信息
     *
     * @param roles 角色集合
     * @return 菜单权限信息
     */
    List<TbMenu> getMenu(List<TbRole> roles);
}