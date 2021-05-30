package com.grainoil.system.mapper;

import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.system.domain.TbPile;
import com.grainoil.system.domain.vo.point_management.PileListVo;
import com.grainoil.system.domain.vo.point_management.PileQueryVo;
import com.grainoil.system.domain.vo.point_management.PileSplitDto;
import com.grainoil.system.domain.vo.point_management.PileVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface TbPileMapper {

    /**
     * 添加堆位信息
     *
     * @param pile 堆位信息
     */
    void insert(@Param("pile") PileVo pile, @Param("currentUser") CurrentUser currentUser);

    /**
     * 根据id获取堆位信息
     *
     * @param pileId 堆位id
     * @return 结果
     */
    TbPile selectByPrimaryKey(Long pileId);

    /**
     * 修改堆位信息
     *
     * @param record 堆位信息
     */
    void updateByPrimaryKey(@Param("record") PileVo record, @Param("currentUser") CurrentUser currentUser);

    /**
     * 统计相同堆位名称或者堆位编码的数量
     *
     * @param pile 堆位信息
     * @param b    添加/修改
     * @return 数量
     */
    Integer count(@Param("pile") PileVo pile, @Param("b") boolean b);

    /**
     * 市(区)粮管中心查询仓房下的堆位,承储企业查询自己仓库下的堆位列表
     *
     * @param pile 堆位信息
     * @return 堆位信息列表
     */
    List<PileListVo> select(PileQueryVo pile);

    /**
     * 承储企业查询"代储"的堆位列表
     *
     * @param organizeId
     * @return
     */
    List<PileListVo> list(@Param("organizeId") Long organizeId, @Param("storehouseId") Long storehouseId);

    /**
     * 验证入库管理明细表堆位数据的正确性
     *
     * @param heapIds 堆位id与子堆id
     * @return 数量
     */
    Integer check(@Param("heapIds") Set<String> heapIds, @Param("storehouseId") Long storehouseId);

    /**
     * 根据id获取堆位以及其属性信息
     *
     * @param id 堆位id
     * @return 结果
     */
    PileVo selectById(Long id);

    /**
     * 验证堆位是否是区粮管下面的
     *
     * @param id         堆位所属仓房id
     * @param organizeId 区粮管id
     * @return 结果
     */
    Integer checkPileToOrganize(@Param("id") Long id, @Param("organizeId") Long organizeId);

    /**
     * 判断堆位是否属于企业
     *
     * @param storehouseId 堆位所属仓房id
     * @param organizeId   企业id
     * @return 结果
     */
    Integer checkInOrganizeId(@Param("storehouseId") Long storehouseId, @Param("organizeId") Long organizeId);

    /**
     * 拆堆时修改堆位信息
     *
     * @param splitDto
     */
    void updateSplit(@Param("splitDto") PileSplitDto splitDto, @Param("currentUser") CurrentUser currentUser);

    /**
     * 合堆时修改堆位信息
     *
     * @param id
     * @param name
     * @param currentUser
     */
    void updateCombine(@Param("id") Long id, @Param("name") String name, @Param("currentUser") CurrentUser currentUser);

}