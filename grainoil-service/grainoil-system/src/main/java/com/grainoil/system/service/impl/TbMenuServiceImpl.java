package com.grainoil.system.service.impl;

import com.grainoil.common.exception.BusinessException;
import com.grainoil.common.utils.StringUtils;
import com.grainoil.system.domain.TbMenu;
import com.grainoil.system.domain.TbRole;
import com.grainoil.system.mapper.TbMenuMapper;
import com.grainoil.system.service.ITbMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 菜单 业务层处理
 *
 */
@Service
public class TbMenuServiceImpl implements ITbMenuService {

    @Autowired
    private TbMenuMapper menuMapper;

    @Override
    public List<Map<String, Object>> getMenu(List<TbRole> roles) {
        if (roles.size() == 0) {
            return new ArrayList<>();
        }
        List<TbMenu> menus = menuMapper.getMenu(roles);
        List<Map<String, Object>> rootTree = getRootTree(menus);
        return update(rootTree);
    }

    private List<Map<String, Object>> update(List<Map<String, Object>> rootTree) {
        for (Map<String, Object> map : rootTree) {
            map.remove("orderNum");
            if (map.get("children") != null) {
                update((List<Map<String, Object>>) map.get("children"));
            }
        }
        return rootTree;
    }

    /**
     * 获取目录根节点后遍历子菜单
     *
     * @param menus 菜单集合
     * @return 前端展示的菜单
     */
    private List<Map<String, Object>> getRootTree(List<TbMenu> menus) {
        List<Map<String, Object>> returns = new ArrayList<>();
        for (TbMenu menu : menus) {
            if (menu.getParentId() == null && StringUtils.isNotBlank(menu.getComponent())) {
                returns.add(TbMenu.getMap(menu));
            }
        }
        if (returns.size() == 0) {
            throw new BusinessException("数据库数据异常,请联系管理员");
        }
        returns.sort((o1, o2) -> (int)((Long) o1.get("orderNum") - (Long) o2.get("orderNum")));
        for (Map<String, Object> menu : returns) {
            getChildTree(menu, menus);
        }
        return returns;
    }

    /**
     * 根据父节点信息查询所有子节点信息
     *
     * @param menu 父节点信息
     * @param menus 菜单集合
     */
    private void getChildTree(Map<String, Object> menu, List<TbMenu> menus) {
        List<Map<String, Object>> children = new ArrayList<>();
        for (TbMenu menu1 : menus) {
            if (menu.get("key").equals(menu1.getParentId()) && StringUtils.isNotBlank(menu1.getComponent())) {
                children.add(TbMenu.getMap(menu1));
            }
        }
        if (children.size() > 0) {
            children.sort(Comparator.comparingLong(o -> (Long) o.get("orderNum")));
            for (Map<String, Object> child : children) {
                getChildTree(child, menus);
                menu.put("children", children);
            }
        }
    }

    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
//    @Override
//    @RedisCache(key = "user_perms", fieldKey = "#userId")
//    public Set<String> selectPermsByUserId(Long userId)
//    {
//        List<String> perms = menuMapper.selectPermsByUserId(userId);
//        Set<String> permsSet = new HashSet<>();
//        for (String perm : perms)
//        {
//            if (StringUtils.isNotEmpty(perm))
//            {
//                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
//            }
//        }
//        return permsSet;
//    }

//    @Override
//    public List<SysMenu> selectMenuIdsByRoleId(Long roleId)
//    {
//        return menuMapper.selectMenuIdsByRoleId(roleId);
//    }



    /**
     * 根据菜单ID查询信息
     *
     * @param menuId 菜单ID
     * @return 菜单信息
     */
//    @Override
//    public TbMenu selectMenuById(Long menuId)
//    {
//        return menuMapper.selectMenuById(menuId);
//    }



}
