package com.grainoil.system.mapper;

import com.grainoil.system.domain.TbDictData;
import com.grainoil.system.domain.TbOrganize;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 字典数据 数据层
 */
public interface TbDictDataMapper {

    /**
     * 根据条件分页查询字典数据
     *
     * @param dictData 字典数据信息
     * @return 字典数据集合信息
     */
    List<TbDictData> selectDictDataList(TbDictData dictData);

    /**
     * 根据字典类型查询字典数据
     *
     * @param dictType 字典类型
     * @return 字典数据集合信息
     */
    List<TbDictData> selectDictDataByType(String dictType);

    /**
     * 根据字典类型和字典键值查询字典数据信息
     *
     * @param dictType  字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    String selectDictLabel(@Param("dictType") String dictType, @Param("dictValue") String dictValue);

    /**
     * 根据字典数据ID查询信息
     *
     * @param dictCode 字典数据ID
     * @return 字典数据
     */
    TbDictData selectDictDataById(Long dictCode);

    /**
     * 查询字典数据数量
     *
     * @param dictId 字典类型
     * @return 字典数据
     */
    int countDictDataByType(Long dictId);

    /**
     * 通过字典ID删除字典数据信息
     *
     * @param dictCode 字典数据ID
     * @return 结果
     */
    int deleteDictDataById(Long dictCode);

    /**
     * 批量删除字典数据
     *
     * @param ids 需要删除的数据
     * @return 结果
     */
    int deleteDictDataByIds(String[] ids);

    /**
     * 新增字典数据信息
     *
     * @param dictData 字典数据信息
     * @return 结果
     */
    int insertDictData(TbDictData dictData);

    /**
     * 修改字典数据信息
     *
     * @param dictData 字典数据信息
     * @return 结果
     */
    int updateDictData(TbDictData dictData);

    /**
     * 同步修改字典类型
     *
     * @param oldDictType 旧字典类型
     * @param newDictType 新旧字典类型
     * @return 结果
     */
    int updateDictDataType(@Param("oldDictType") String oldDictType, @Param("newDictType") String newDictType);

    /**
     * 统计相同数据的数量
     *
     * @param dictData 字典数据信息
     * @param b 是新增还是修改
     * @return 存在相同数据的数量
     */
    int count(@Param("dictData") TbDictData dictData, @Param("b") boolean b);

    /**
     * 判断父子节点之间的关系是否正确
     *
     * @param organize 组织信息
     * @return true/false
     */
    boolean verify(TbOrganize organize);
}