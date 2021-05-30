package com.grainoil.system.mapper;

import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.system.domain.TbStorehouse;
import com.grainoil.system.domain.vo.point_management.StorehouseListVo;
import com.grainoil.system.domain.vo.point_management.StorehouseQuery;
import com.grainoil.system.domain.vo.point_management.StorehouseVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TbStorehouseMapper {

    /**
     * 添加仓房信息
     *
     * @param record 仓房信息
     * @return 结果
     */
    int insert(@Param("record") StorehouseVo record, @Param("currentUser") CurrentUser currentUser);

    /**
     * 根据id获取仓房信息
     *
     * @param storehouseId 仓房id
     * @return 仓房信息
     */
    TbStorehouse selectByPrimaryKey(Long storehouseId);

    /**
     * 市区粮管修改仓房信息
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(@Param("record") StorehouseVo record, @Param("currentUser") CurrentUser currentUser);

    /**
     * 统计同一粮库下相同仓房名称或者仓房编码的数量
     *
     * @param storehouse 仓房信息
     * @param b          添加/修改
     * @return 数量
     */
    Integer count(@Param("storehouse") StorehouseVo storehouse, @Param("b") boolean b);

    /**
     * 市粮管中心(区粮管中心/承储企业旗下粮库)根据粮库id查询粮库下所有的仓房信息
     *
     * @param storehouse 仓房查询条件
     * @return 仓房信息集合
     */
    List<StorehouseListVo> select(@Param("storehouse") StorehouseQuery storehouse, @Param("organizeId") Long organizeId);

    /**
     * 承储企业'代储'粮库根据粮库id查询粮库下所有的仓房信息
     * (当既不是'我的'也不是'代储'粮库时, 根据粮库id查询粮库下所有的仓房信息也符合该sql,只是查出来为空集合)
     *
     * @param storehouse 仓房查询条件
     * @param organizeId 企业id
     * @return 仓房信息集合
     */
    List<StorehouseListVo> select2(@Param("storehouse") StorehouseQuery storehouse, @Param("organizeId") Long organizeId);

    /**
     * 判断仓库是否属于对应组织
     *
     * @param storehouseId
     */
    Integer checkInOrganize(@Param("storehouseId") Long storehouseId, @Param("organizeId") Long organizeId);

    /**
     * 判断仓房是否存在或者已停用
     *
     * @param storehouseId 仓房id
     * @return 结果
     */
    Integer judge(Long storehouseId);

    /**
     * 根据粮库id查询仓房列表
     *
     * @param grainDepotId 粮库id
     * @return 仓房列表
     */
    List<Map<String, Object>> search(Long grainDepotId);

    /**
     * 根据粮库id查询'代储'仓房列表
     *
     * @param grainDepotId 粮库id
     * @param organizeId   组织id
     * @return 仓房列表
     */
    List<Map<String, Object>> search2(@Param("grainDepotId") Long grainDepotId, @Param("organizeId") Long organizeId);

    /**
     * 判断仓房所属粮库的粮权是否是该组织
     *
     * @param id         仓房id
     * @param organizeId 组织id
     * @return 结果
     */
    Integer checkInOrganizeLq(@Param("id") Long id, @Param("organizeId") Long organizeId);

    /**
     * 承储企业修改仓房信息
     *
     * @param storehouse
     * @param currentUser
     */
    void update(@Param("storehouse") StorehouseVo storehouse, @Param("currentUser") CurrentUser currentUser);
}