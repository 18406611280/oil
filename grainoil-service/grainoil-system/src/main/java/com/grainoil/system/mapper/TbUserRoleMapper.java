package com.grainoil.system.mapper;

import com.grainoil.system.domain.TbUserRole;

public interface TbUserRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbUserRole record);

    int insertSelective(TbUserRole record);

    TbUserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbUserRole record);

    int updateByPrimaryKey(TbUserRole record);
}