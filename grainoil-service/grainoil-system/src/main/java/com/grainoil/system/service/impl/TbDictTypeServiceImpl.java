package com.grainoil.system.service.impl;

import com.grainoil.common.constant.UserConstants;
import com.grainoil.common.core.domain.BaseMap;
import com.grainoil.common.core.domain.R;
import com.grainoil.common.core.text.Convert;
import com.grainoil.common.exception.BusinessException;
import com.grainoil.common.utils.StringUtils;
import com.grainoil.system.domain.TbDictType;
import com.grainoil.system.mapper.TbDictDataMapper;
import com.grainoil.system.mapper.TbDictTypeMapper;
import com.grainoil.system.service.ITbDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 字典 业务层处理
 */
@Service
public class TbDictTypeServiceImpl implements ITbDictTypeService {

    @Autowired
    private TbDictTypeMapper dictTypeMapper;

    @Autowired
    private TbDictDataMapper dictDataMapper;

    /**
     * 根据条件分页查询字典类型
     *
     * @param dictType 字典类型信息
     * @return 字典类型集合信息
     */
    @Override
    public List<TbDictType> selectDictTypeList(TbDictType dictType) {
        return dictTypeMapper.selectDictTypeList(dictType);
    }

    /**
     * 根据所有字典类型
     *
     * @return 字典类型集合信息
     */
    @Override
    public List<TbDictType> selectDictTypeAll() {
        return dictTypeMapper.selectDictTypeAll();
    }

    /**
     * 根据字典类型ID查询信息
     *
     * @param dictId 字典类型ID
     * @return 字典类型
     */
    @Override
    public TbDictType selectDictTypeById(Long dictId) {
        return dictTypeMapper.selectDictTypeById(dictId);
    }

    /**
     * 通过字典ID删除字典信息
     *
     * @param dictId 字典ID
     * @return 结果
     */
    @Override
    public int deleteDictTypeById(Long dictId) {
        return dictTypeMapper.deleteDictTypeById(dictId);
    }

    /**
     * 批量删除字典类型
     *
     * @param ids 需要删除的数据
     * @return 结果
     */
    @Override
    public int deleteDictTypeByIds(String ids) {
        Long[] dictIds = Convert.toLongArray(ids);
        for (Long dictId : dictIds) {
            TbDictType dictType = selectDictTypeById(dictId);
            if (dictDataMapper.countDictDataByType(dictType.getDictId()) > 0) {
                throw new BusinessException(String.format("%1$s已分配,不能删除", dictType.getDictName()));
            }
        }
        return dictTypeMapper.deleteDictTypeByIds(dictIds);
    }

    /**
     * 新增保存字典类型信息
     *
     * @param dictType 字典类型信息
     * @return 结果
     */
    @Override
    public R insertDictType(TbDictType dictType) {
        Map<String, Object> map = verify(dictType, false);
        if (map.get("success").equals(false)) {
            return R.error(map.get("msg") + "");
        }
        String s = checkDictTypeUnique(dictType);
        if (s.equals(UserConstants.DICT_TYPE_UNIQUE)) {
            int i = dictTypeMapper.insertDictType(dictType);
            return i > 0 ? R.ok() : R.error();
        } else {
            return R.error("字典类型或字典名称已存在");
        }
    }

    private Map<String, Object> verify(TbDictType dictType, boolean b) {
        if (dictType == null) {
            return BaseMap.getFailureMap("数据获取异常");
        }
        if (b && dictType.getDictId() == null) {
            return BaseMap.getFailureMap("数据不完整");
        }
        if (StringUtils.isBlank(dictType.getDictName()) || StringUtils.isBlank(dictType.getDictType())) {
            return BaseMap.getFailureMap("数据不完整");
        }
        return BaseMap.getSuccessMap();
    }

    /**
     * 修改保存字典类型信息
     *
     * @param dictType 字典类型信息
     * @return 结果
     */
    @Override
    public R updateDictType(TbDictType dictType) {
        Map<String, Object> map = verify(dictType, true);
        if (map.get("success").equals(false)) {
            return R.error(map.get("msg") + "");
        }
        String s = checkDictTypeUnique(dictType);
        if (s.equals(UserConstants.DICT_TYPE_UNIQUE)) {
            int i = dictTypeMapper.updateDictType(dictType);
            return i > 0 ? R.ok() : R.error();
        } else {
            return R.error("字典类型或字典名称已存在");
        }
    }

    /**
     * 校验字典类型称是否唯一
     *
     * @param dict 字典类型
     * @return 结果
     */
    @Override
    public String checkDictTypeUnique(TbDictType dict) {
        Long dictId = StringUtils.isNull(dict.getDictId()) ? -1L : dict.getDictId();
        List<TbDictType> dictTypes = dictTypeMapper.checkDictTypeUnique(dict, dictId);
        if (dictTypes.size() > 0) {
            return UserConstants.DICT_TYPE_NOT_UNIQUE;
        }
        return UserConstants.DICT_TYPE_UNIQUE;
    }
}
