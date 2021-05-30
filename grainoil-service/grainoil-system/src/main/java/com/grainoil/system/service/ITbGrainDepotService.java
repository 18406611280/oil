package com.grainoil.system.service;

import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.common.core.domain.ResponseResult;
import com.grainoil.system.domain.vo.common.LeafNode;
import com.grainoil.system.domain.vo.common.SecondNode;
import com.grainoil.system.domain.vo.common.ThirdNode;
import com.grainoil.system.domain.vo.point_management.*;

import java.util.List;
import java.util.Map;

public interface ITbGrainDepotService {

    /**
     * 添加粮库信息
     *
     * @param depot 粮库信息
     * @return 结果
     */
    ResponseResult insert(GrainDepotInsert depot, CurrentUser currentUser);

    /**
     * 根据条件查询粮库信息集合
     *
     * @param depot 粮库查询条件
     * @param organizeId 当前用户所属市区组织id
     * @param organizeType 组织类型(数字字典)
     * @return 粮库信息集合
     */
    ResponseResult<List<GrainDepotListVo>> list(GrainDepotQueryVo depot, Long organizeId, String organizeType);

    /**
     * 修改粮库信息
     * @param depot
     * @return
     */
    ResponseResult update(GrainDepotUpdate depot, CurrentUser currentUser, Long organizeId, String organizeType);

    /**
     * 获取修改时的粮库信息
     *
     * @param grainDepotId 粮库id
     * @return 结果
     */
    ResponseResult<GrainDepotGet> getUpdate(Long grainDepotId, Long organizeId, String organizeType);

    /**
     * 获取所有的粮库下拉框
     *
     * @return 粮库下拉框
     */
    List<Map<String, Object>> getGrainDepots();

    /**
     * 添加存储合同添加明细表的添加按钮
     *
     * @param id 粮库id
     * @return 数据列表
     */
    List<Map<String, Object>> getStorageDetailList(Long id);

    /**
     * 获取列表查询条件粮库下拉框
     *
     * @return
     */
    List<LeafNode> getGrainDepotList(Long organizeId, String organizeType);

    /**
     * 获取粮库仓房联动下拉框
     *
     * @param organizeId
     * @param organizeType
     * @return
     */
    List<SecondNode> getSecondNode(Long organizeId, String organizeType);

    /**
     * 获取粮库-仓房-堆位联动下拉框
     *
     * @param organizeId
     * @param organizeType
     * @return
     */
    List<ThirdNode> getThirdNode(Long organizeId, String organizeType);
}
