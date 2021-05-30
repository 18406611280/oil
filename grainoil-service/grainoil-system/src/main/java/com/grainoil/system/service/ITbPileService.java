package com.grainoil.system.service;

import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.common.core.domain.ResponseResult;
import com.grainoil.system.domain.vo.point_management.PileListVo;
import com.grainoil.system.domain.vo.point_management.PileQueryVo;
import com.grainoil.system.domain.vo.point_management.PileSplitDto;
import com.grainoil.system.domain.vo.point_management.PileVo;

import java.util.List;

public interface ITbPileService {

    /**
     * 添加堆位信息
     *
     * @param pile 堆位信息
     * @return 结果
     */
    ResponseResult insert(PileVo pile, CurrentUser currentUser);

    /**
     * 修改堆位信息
     *
     * @param pile 堆位信息
     * @return 结果
     */
    ResponseResult update(PileVo pile, CurrentUser currentUser);

    /**
     * 根据id获取堆位信息
     *
     * @param id 堆位id
     * @return 结果
     */
    ResponseResult<PileVo> getUpdate(Long id, Long organizeId, String organizeType);

    /**
     * 堆位信息列表
     *
     * @param pile
     * @return
     */
    ResponseResult<List<PileListVo>> list(PileQueryVo pile, String organizeType, Long organizeId);

    /**
     * 拆堆
     *
     * @param splitDto
     * @return
     */
    ResponseResult split(PileSplitDto splitDto, CurrentUser currentUser);

    /**
     * 合堆
     *
     * @param id
     * @return
     */
    ResponseResult combine(Long id, CurrentUser currentUser);

    /**
     * 能否拆堆
     *
     * @param id 堆位id
     * @return
     */
    ResponseResult canSplit(Long id);
}
