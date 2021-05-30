package com.grainoil.system.service;

import com.grainoil.system.domain.TbRole;

import java.util.List;
import java.util.Map;

/**
 * 菜单 业务层
 */
public interface ITbMenuService {

    List<Map<String, Object>> getMenu(List<TbRole> roles);
}
