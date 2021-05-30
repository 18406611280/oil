package com.grainoil.system.service;

import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.common.core.domain.R;
import com.grainoil.common.core.domain.ResponseResult;
import com.grainoil.system.domain.TbVariety;
import com.grainoil.system.domain.vo.variety.VarietyVo;
import com.grainoil.system.domain.vo.variety.VarietyListVo;

import java.util.List;

public interface ITbVarietyService {

    /**
     * 查询粮油品种列表
     *
     * @return 结果
     */
    List<VarietyListVo> list();

    /**
     * 添加粮油品种信息
     *
     * @param varietyVo 粮油品种信息
     * @return ok/error
     */
    ResponseResult insert(VarietyVo varietyVo, CurrentUser currentUser);

    /**
     * 修改粮油品种信息
     *
     * @param varietyVo 粮油品种信息
     * @return ok/error
     */
    ResponseResult update(VarietyVo varietyVo, CurrentUser currentUser);

    /**
     * 根据id查询粮油品种信息
     *
     * @param id 粮油品种id
     * @return 粮油品种信息
     */
    ResponseResult get(Long id);

    /**
     * 根据id删除粮油品种信息
     *
     * @param tbVariety 粮油品种信息
     * @return 结果
     */
    ResponseResult delete(TbVariety tbVariety);

    /**
     * 获取粮油品种下拉框列表
     *
     * @return 粮油品种下拉框
     */
    ResponseResult getSelect();

}
