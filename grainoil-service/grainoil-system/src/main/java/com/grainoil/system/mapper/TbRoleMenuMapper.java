package com.grainoil.system.mapper;

import com.grainoil.system.domain.TbRoleMenu;

public interface TbRoleMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbRoleMenu record);

    int insertSelective(TbRoleMenu record);

    TbRoleMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbRoleMenu record);

    int updateByPrimaryKey(TbRoleMenu record);
}