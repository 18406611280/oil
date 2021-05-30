package com.grainoil.system.service.impl;

import com.grainoil.common.core.domain.BaseMap;
import com.grainoil.common.core.domain.R;
import com.grainoil.common.exception.BusinessException;
import com.grainoil.common.exception.GrainOilException;
import com.grainoil.common.utils.StringUtils;
import com.grainoil.system.domain.TbOrganize;
import com.grainoil.system.domain.vo.OrganizeTreeVo;
import com.grainoil.system.mapper.TbDictDataMapper;
import com.grainoil.system.mapper.TbOrganizeMapper;
import com.grainoil.system.service.ITbOrganizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TbOrganizeServiceImpl implements ITbOrganizeService {

    @Autowired
    TbOrganizeMapper organizeMapper;

    @Autowired
    TbDictDataMapper dictDataMapper;

    /**
     * 根据条件分页查询组织信息列表
     *
     * @param organizeName 组织名称
     * @param organizeType 组织类型
     * @param organizeId 组织id
     * @return 组织信息集合
     */
    @Override
    public List<TbOrganize> list(String organizeName, String organizeType, Long organizeId) {
        TbOrganize organize = new TbOrganize();
        organize.setOrganizeType(organizeType);
        organize.setOrganizeName(organizeName);
        organize.setOrganizeId(organizeId);
        return organizeMapper.list(organize);
    }

    /**
     * 添加组织信息
     *
     * @param organize 组织信息
     * @return number
     */
    @Override
    public R insert(TbOrganize organize, Long organizeId) {
        String type = organizeMapper.getTypeById(organizeId);
        if (type == null) {
            return R.error("组织不存在");
        }
        if (organize.getOrganizeType() == null || organize.getOrganizeNote() == null || StringUtils.isBlank(organize.getOrganizeName())) {
            return R.error("新增的数据不完整");
        }
        if (type == null) {
            if (organize.getParentId() == null) {
//                if (organize.getOrganizeType() == 1 || organize.getOrganizeType() == 4) {
//                    return R.error("上级组织错误");
//                }
            }
            if (organize.getParentId() != null) {
                if (!dictDataMapper.verify(organize)) {
                    return R.error("上下级之间的关系错误");
                }
            }
            Map<String, Object> map = setParents(organize);
            if (map.get("success").equals(false)) {
                return R.error(map.get("msg") + "");
            }
            int insert = organizeMapper.insert(organize);
            return insert > 0 ? R.ok() : R.error();
        } else {
            if (organize.getParentId() == null) {
                return R.error("上级组织错误");
            }
            if (!dictDataMapper.verify(organize)) {
                return R.error("上下级之间的关系错误");
            }
            Map<String, Object> map = setParents(organize);
            if (map.get("success").equals(false)) {
                return R.error(map.get("msg") + "");
            }
            int insert = organizeMapper.insert(organize);
            return insert > 0 ? R.ok() : R.error();
        }
    }

    /**
     * 对父节点集合进行赋值
     *
     * @param organize 组织信息
     */
    private Map<String, Object> setParents(TbOrganize organize) {
        Map<String, Object> map = organizeMapper.getParents(organize.getParentId());
        if (!"0".equals(map.get("del_flag"))) {
            return BaseMap.getFailureMap("添加的上级组织已删除");
        }
        if (!"0".equals(map.get("organize_state"))) {
            return BaseMap.getFailureMap("添加的上级组织已禁用");
        }
        if (map.get("parents") == null || "".equals((map.get("parents") + "").trim())) {
            organize.setParents(null);
        } else {
            organize.setParents(map.get("parents") + "," + organize.getParentId());
        }
        return BaseMap.getSuccessMap();
    }

    /**
     * 获取组织管理树
     *
     * @param id 树的根节点id
     * @return 组织管理树结构
     */
    @Override
    public List<OrganizeTreeVo> getTree(Long id) {
        if (id == null) {
            throw new GrainOilException("组织id不能为null");
        }
        String type = organizeMapper.getTypeById(id);
        if (type == null) {
            throw new BusinessException("组织类型不合法");
        }
        List<TbOrganize> list;
        List<Long> ids = new ArrayList<>();
        if (type == null) {
            list = organizeMapper.getTree(null);
            for (TbOrganize tbOrganize : list) {
                if (tbOrganize.getParentId() == null) {
                    ids.add(tbOrganize.getOrganizeId());
                }
            }
        } else {
//            list = organizeMapper.getTree(id);
//            ids.add(Long.parseLong(id));
        }
        if (ids.size() == 0) {
            return new ArrayList<>();
        }
        List<OrganizeTreeVo> result = new ArrayList<>();
        for (Long aLong : ids) {
//            result.add(analyze(list, aLong));
        }
        return result;
    }

    /**
     * 根据id获取组织信息
     *
     * @param organizeId 组织id
     * @return 组织信息
     */
    @Override
    public R get(Long organizeId) {
        if (organizeId == null) {
            throw new GrainOilException("组织id不能为null");
        }
        TbOrganize tbOrganize = organizeMapper.selectByPrimaryKey(organizeId);
        if (tbOrganize == null) {
            return R.error("根据该组织id查询的信息为null");
        }
        return R.data(tbOrganize);
    }

    /**
     * 修改组织信息
     *
     * @param organize 组织信息
     * @return number
     */
    @Override
    public R update(TbOrganize organize) {
//        return organizeMapper.updateByPrimaryKey(organize);

        return null;
    }

    /**
     * 获取所有的企业的下拉框
     *
     * @return 结果
     */
    @Override
    public R getSelect() {
        return R.data(organizeMapper.getSelect());
    }

    /**
     * 获取区粮管中心组织的下拉框
     *
     * @return 所有的企业的下拉框
     */
    @Override
    public R getCenter() {
        return R.data(organizeMapper.getCenter());
    }

    /**
     * 对组织管理进行分析,形成组织管理树
     *
     * @param list 组织管理集合
     * @param id 节点id
     * @return 树结构
     */
    private OrganizeTreeVo analyze(List<TbOrganize> list, Long id) {
        OrganizeTreeVo vo = new OrganizeTreeVo();
        for (TbOrganize tbOrganize : list) {
            if (id.equals(tbOrganize.getOrganizeId())) {
                vo.setKey(id + "");
                vo.setTitle(tbOrganize.getOrganizeName());
                break;
            }
        }
        List<OrganizeTreeVo> children = new ArrayList<>();
        for (TbOrganize tbOrganize : list) {
            if (id.equals(tbOrganize.getParentId())) {
                children.add(analyze(list, tbOrganize.getOrganizeId()));
            }
        }
        if (children.size() == 0) {
            children = null;
        }
        vo.setChildren(children);
        return vo;
    }
}
