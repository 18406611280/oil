package com.grainoil.system.mapper;

import com.grainoil.system.domain.TbFile;
import com.grainoil.system.domain.vo.FileVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TbFileMapper {

    Integer insert(TbFile record);

    TbFile selectByPrimaryKey(Long fileId);

    /**
     * 根据文件id集合查询文件信息集合
     *
     * @param split 文件id集合
     * @return 文件信息集合
     */
    List<FileVo> getFileVo(String[] split);

    @Select("SELECT file_id fileId, file_name fileName, url FROM public.tb_file WHERE file_id = #{id}")
    FileVo getFileVoById(@Param("id") Long id);
}