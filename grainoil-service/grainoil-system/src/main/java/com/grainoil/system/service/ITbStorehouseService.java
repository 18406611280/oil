package com.grainoil.system.service;

import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.common.core.domain.R;
import com.grainoil.common.core.domain.ResponseResult;
import com.grainoil.system.domain.TbStorehouse;
import com.grainoil.system.domain.vo.point_management.*;

import java.util.List;
import java.util.Map;

public interface ITbStorehouseService {

    /**
     * 添加仓房信息
     *
     * @param storehouse 仓房信息
     * @return 结果
     */
    ResponseResult insert(StorehouseVo storehouse, CurrentUser currentUser);

    /**
     * 根据条件查询仓房列表信息
     *
     * @param storehouse 仓房信息
     * @param organizeId 组织部门id
     * @return 仓库列表信息
     */
    ResponseResult<List<StorehouseListVo>> list(StorehouseQuery storehouse, String organizeType, Long organizeId);

    /**
     * 修改仓房信息
     *
     * @param storehouse 仓房信息
     * @return 结果
     */
    ResponseResult update(StorehouseVo storehouse, CurrentUser currentUser);

    /**
     * 根据仓房id获取仓房信息
     *
     * @param id 仓房id
     * @return 结果
     */
    ResponseResult<StorehouseGet> getUpdate(Long id, String organizeType, Long organizeId);

    /**
     * 根据粮库id查询仓房列表
     *
     * @param grainDepotId 粮库id
     * @return 仓房列表
     */
    List<Map<String, Object>> search(Long grainDepotId, String organizeType, Long organizeId);

    /**
     * 仓房所属企业修改时使用企业的添加按钮中的组织下拉框
     *
     * @param id 粮库id
     * @return 组织信息列表
     */
    List<OrganizeVo> getOrganizeVoSelect(Long id);

    /**
     * 仓房所属企业修改时使用企业的添加按钮
     *
     * @param id
     * @param organizeId
     * @return
     */
    List<OrganizeVo> getOrganizeVo(Long id, Long organizeId, Long organizeIds);
}
