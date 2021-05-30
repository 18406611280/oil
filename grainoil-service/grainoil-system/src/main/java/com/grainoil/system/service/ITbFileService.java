package com.grainoil.system.service;

import com.grainoil.system.domain.TbFile;

public interface ITbFileService {

    /**
     * 数据库添加上传文件信息
     *
     * @param tbFile 文件信息
     * @return 结果
     */
    Integer insert(TbFile tbFile);

    /**
     * 根据文件id查询文件信息
     *
     * @param fileId 文件id
     * @return 文件信息
     */
    TbFile findFileById(Long fileId);
}
