package com.grainoil.system.mapper;

import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.system.domain.TbManStorage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbManStorageMapper {
    int insert(TbManStorage record);

    TbManStorage selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(TbManStorage record);

    /**
     * 删除负责人与存储单位间的关系
     *
     * @param storeId   存储单位id
     * @param storeType 存储单位类型
     */
    void delete(@Param("userIds") List<Long> userIds, @Param("storeId") Long storeId, @Param("storeType") String storeType, @Param("currentUser") CurrentUser currentUser);

    /**
     * 批量添加存储单位与负责人之间的关系
     *
     * @param personId 负责人id集合
     * @param storeId 存储单位id
     * @param storeType 存储类型
     * @param currentUser 当前用户信息
     */
    void batchInsert(@Param("personId") List<Long> personId, @Param("storeId") Long storeId, @Param("storeType") String storeType, @Param("currentUser") CurrentUser currentUser);
}