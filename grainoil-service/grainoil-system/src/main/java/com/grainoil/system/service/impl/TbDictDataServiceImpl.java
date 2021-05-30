package com.grainoil.system.service.impl;

import com.grainoil.common.core.domain.BaseMap;
import com.grainoil.common.core.domain.R;
import com.grainoil.common.core.text.Convert;
import com.grainoil.common.utils.StringUtils;
import com.grainoil.system.domain.TbDictData;
import com.grainoil.system.domain.TbDictType;
import com.grainoil.system.mapper.TbDictDataMapper;
import com.grainoil.system.mapper.TbDictTypeMapper;
import com.grainoil.system.service.ITbDictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 数字字典数据 业务层处理
 */
@Service
public class TbDictDataServiceImpl implements ITbDictDataService {
    @Autowired
    private TbDictDataMapper dictDataMapper;

    @Autowired
    private TbDictTypeMapper dictTypeMapper;

    /**
     * 根据条件分页查询字典数据
     * 
     * @param dictData 字典数据信息
     * @return 字典数据集合信息
     */
    @Override
    public List<TbDictData> selectDictDataList(TbDictData dictData) {
        return dictDataMapper.selectDictDataList(dictData);
    }

    /**
     * 根据字典类型查询字典数据
     * 
     * @param dictType 字典类型
     * @return 字典数据集合信息
     */
    @Override
    public List<TbDictData> selectDictDataByType(String dictType) {
        return dictDataMapper.selectDictDataByType(dictType);
    }

    /**
     * 根据字典类型和字典键值查询字典数据信息
     * 
     * @param dictType 字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    @Override
    public String selectDictLabel(String dictType, String dictValue) {
        return dictDataMapper.selectDictLabel(dictType, dictValue);
    }

    /**
     * 根据字典数据ID查询信息
     * 
     * @param dictCode 字典数据ID
     * @return 字典数据
     */
    @Override
    public TbDictData selectDictDataById(Long dictCode) {
        return dictDataMapper.selectDictDataById(dictCode);
    }

    /**
     * 通过字典ID删除字典数据信息
     * 
     * @param dictCode 字典数据ID
     * @return 结果
     */
    @Override
    public int deleteDictDataById(Long dictCode) {
        return dictDataMapper.deleteDictDataById(dictCode);
    }

    /**
     * 批量删除字典数据
     * 
     * @param ids 需要删除的数据
     * @return 结果
     */
    @Override
    public int deleteDictDataByIds(String ids) {
        return dictDataMapper.deleteDictDataByIds(Convert.toStrArray(ids));
    }

    /**
     * 新增保存字典数据信息
     * 
     * @param dictData 字典数据信息
     * @return 结果
     */
    @Override
    public R insertDictData(TbDictData dictData) {
        Map<String, Object> map = verify(dictData, false);
        if (map.get("success").equals(false)) {
            return R.error(map.get("msg") + "");
        }
        int i = dictDataMapper.insertDictData(dictData);
        return i > 0 ? R.ok() : R.error();
    }

    private Map<String, Object> verify(TbDictData dictData, boolean b) {
        if (dictData == null) {
            return BaseMap.getFailureMap("数据获取异常");
        }
        if (b && (dictData.getDictCode() == null || StringUtils.isBlank(dictData.getStatus()))) {
            return BaseMap.getFailureMap("数据不完整");
        }
        if (dictData.getDictType() == null || StringUtils.isBlank(dictData.getDictLabel()) || StringUtils.isBlank(dictData.getDictValue())) {
            return BaseMap.getFailureMap("数据不完整");
        }
        TbDictType tbDictType = dictTypeMapper.selectDictTypeById(dictData.getDictType());
        if (tbDictType == null) {
            return BaseMap.getFailureMap("字典类型不存在");
        }
        int num = dictDataMapper.count(dictData, b);
        if (num > 0) {
            return BaseMap.getFailureMap("字典键值或者字典标签已存在");
        }
        return BaseMap.getSuccessMap();
    }

    /**
     * 修改保存字典数据信息
     * 
     * @param dictData 字典数据信息
     * @return 结果
     */
    @Override
    public R updateDictData(TbDictData dictData) {
        Map<String, Object> map = verify(dictData, true);
        if (map.get("success").equals(false)) {
            return R.error(map.get("msg") + "");
        }
        int i = dictDataMapper.updateDictData(dictData);
        return i > 0 ? R.ok() : R.error();
    }
}
