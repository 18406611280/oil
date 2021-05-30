package com.grainoil.system.service.impl;

import com.grainoil.common.core.domain.BaseMap;
import com.grainoil.common.core.domain.CurrentUser;
import com.grainoil.common.core.domain.R;
import com.grainoil.common.core.domain.ResponseResult;
import com.grainoil.common.exception.BusinessException;
import com.grainoil.common.utils.StringUtils;
import com.grainoil.system.domain.TbVariety;
import com.grainoil.system.domain.vo.variety.VarietyChildren;
import com.grainoil.system.domain.vo.variety.VarietyVo;
import com.grainoil.system.domain.vo.variety.VarietyListVo;
import com.grainoil.system.mapper.TbVarietyMapper;
import com.grainoil.system.service.ITbVarietyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class TbVarietyServiceImpl implements ITbVarietyService {

    @Autowired
    TbVarietyMapper varietyMapper;

    /**
     * 查询粮油品种列表
     *
     * @return 结果
     */
    @Override
    public List<VarietyListVo> list() {
        return varietyMapper.list();
    }

    /**
     * 添加粮油品种信息
     *
     * @param varietyVo 粮油品种信息
     * @return ok/error
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult insert(VarietyVo varietyVo, CurrentUser currentUser) {
        Map<String, Object> map = verify(varietyVo, false);
        if (map.get("success").equals(false)) {
            return ResponseResult.error(map.get("msg") + "");
        }
        int insert = varietyMapper.insert(varietyVo, currentUser);
        if (insert > 0) {
            List<VarietyChildren> varietyList = varietyVo.getList();
            if (varietyList.size() == 0) {
                return ResponseResult.success();
            }
            int i = varietyMapper.batchInsert(varietyList, varietyVo.getVarietyId(), currentUser);
            if (i == varietyList.size()) {
                return ResponseResult.success();
            } else {
                throw new BusinessException("添加二级粮油品种失败");
            }
        } else {
            return ResponseResult.error("添加一级粮油品种失败");
        }
    }

    /**
     * 修改粮油品种信息
     *
     * @param varietyVo 粮油品种信息
     * @return ok/error
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult update(VarietyVo varietyVo, CurrentUser currentUser) {
        Map<String, Object> map = verify(varietyVo, true);
        if (map.get("success").equals(false)) {
            return ResponseResult.error(map.get("msg") + "");
        }
        List<VarietyChildren> list = varietyMapper.selectByParentId(varietyVo.getVarietyId());
        if (list.size() > 0) {
            Integer num = varietyMapper.batchDelete(varietyVo, currentUser);
            if (num != list.size()) {
                throw new BusinessException("清除原二级粮油品种集合失败");
            }
        }
        if (varietyVo.getList().size() != 0) {
            int i = varietyMapper.batchInsert(varietyVo.getList(), varietyVo.getVarietyId(), currentUser);
            if (i != varietyVo.getList().size()) {
                throw new BusinessException("修改二级粮油品种集合失败");
            }
        }
        if (varietyVo.isDisabled()) {
            int i = varietyMapper.updateByPrimaryKey(varietyVo, currentUser);
            if (i > 0) {
                return ResponseResult.success();
            } else {
                throw new BusinessException("修改一级粮油品种失败");
            }
        }
        return ResponseResult.success();
    }

    /**
     * 根据id查询粮油品种信息
     *
     * @param id 粮油品种id
     * @return 粮油品种信息
     */
    @Override
    public ResponseResult get(Long id) {
        TbVariety variety = varietyMapper.selectByPrimaryKey(id);
        if (variety == null) {
            return ResponseResult.error("获取粮油信息失败");
        }
        if (variety.getParentId() == null) {
            VarietyVo varietyVo = getVarietyVo(id, true);
            return ResponseResult.success(varietyVo);
        } else {
            VarietyVo varietyVo = getVarietyVo(variety.getParentId(), false);
            return ResponseResult.success(varietyVo);
        }
    }

    /**
     * 根据id删除粮油品种信息
     *
     * @param tbVariety 粮油品种信息
     * @return 结果
     */
    @Override
    public ResponseResult delete(TbVariety tbVariety) {
        Long parentId = varietyMapper.getParentId(tbVariety.getVarietyId());
        if (parentId == null) {
            Integer num = varietyMapper.count(tbVariety.getVarietyId());
            if (num > 0) {
                return ResponseResult.error("该粮油品种还有二级粮油品种,请先删除二级粮油品种");
            }
        }
        Integer num = varietyMapper.delete(tbVariety);
        return num > 0 ? ResponseResult.success() : ResponseResult.error();
    }

    /**
     * 获取粮油品种下拉框列表
     *
     * @return 粮油品种下拉框
     */
    @Override
    public ResponseResult getSelect() {
        return ResponseResult.success(varietyMapper.getSelect());
    }

    /**
     * 获取粮油品种信息, id分为一级品种id, 二级品种id
     *
     * @param id 粮油品种id
     * @param disabled true 表示id为一级粮油品种id, false 表示id为二级粮油品种id
     * @return 粮油品种信息
     */
    private VarietyVo getVarietyVo(Long id, boolean disabled) {
        VarietyVo varietyVo = new VarietyVo();
        varietyVo.setDisabled(disabled);
        TbVariety variety = varietyMapper.selectByPrimaryKey(id);
        varietyVo.setVarietyId(variety.getVarietyId());
        varietyVo.setVarietyName(variety.getVarietyName());
        varietyVo.setVarietyShortname(variety.getVarietyShortname());
        varietyVo.setPercent(variety.getPercent());
        varietyVo.setRotationPercent(variety.getRotationPercent());
        varietyVo.setMonths(variety.getMonths());
        varietyVo.setRemark(variety.getRemark());
        List<VarietyChildren> list = varietyMapper.selectByParentId(id);
        varietyVo.setList(list);
        return varietyVo;
    }

    /**
     * 验证粮油品种添加修改时的传参是否正确
     *
     * @param varietyVo 粮油品种信息
     * @param b 是添加还是修改
     * @return 结果
     */
    private Map<String, Object> verify(VarietyVo varietyVo, boolean b) {
//        if (!b || (varietyVo.isDisabled() && b)) {
//            if (StringUtils.isBlank(varietyVo.getVarietyName()) || StringUtils.isBlank(varietyVo.getVarietyShortname()) || varietyVo.getList() == null
//                    || varietyVo.getPercent() == null || varietyVo.getMonths() == null || varietyVo.getRotationPercent() == null) {
//                return BaseMap.getFailureMap("数据不完整");
//            }
//        }

        List<VarietyChildren> list = varietyVo.getList();
        Set<String> names = new HashSet<>();
        Set<String> shortnames = new HashSet<>();
        if (!b || varietyVo.isDisabled()) {
            names.add(varietyVo.getVarietyName());
            shortnames.add(varietyVo.getVarietyShortname());
        }
        for (VarietyChildren children : list) {
            names.add(children.getVarietyName());
            shortnames.add(children.getVarietyShortname());
        }
        if (!b || varietyVo.isDisabled()) {
            if ((list.size() + 1) != names.size() || (list.size() + 1) != shortnames.size()) {
                return BaseMap.getFailureMap("出现相同的粮油品种名称或者拼音简写");
            }
        } else {
            if (list.size() != names.size() || list.size() != shortnames.size()) {
                return BaseMap.getFailureMap("出现相同的粮油品种名称或者拼音简写");
            }
        }
        Integer num = varietyMapper.checkName(names, shortnames, b, varietyVo);
        if (num > 0) {
            return BaseMap.getFailureMap("粮油品种名称或者拼音简写已存在");
        }
        return BaseMap.getSuccessMap();
    }
}
