package com.grainoil.system.service.impl;

import com.grainoil.system.domain.TbFile;
import com.grainoil.system.mapper.TbFileMapper;
import com.grainoil.system.service.ITbFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TbFileServiceImpl implements ITbFileService {

    @Autowired
    TbFileMapper fileMapper;

    /**
     * 数据库添加上传文件信息
     *
     * @param tbFile 文件信息
     * @return 结果
     */
    @Override
    public Integer insert(TbFile tbFile) {
        return fileMapper.insert(tbFile);
    }

    /**
     * 根据文件id查询文件信息
     *
     * @param fileId 文件id
     * @return 文件信息
     */
    @Override
    public TbFile findFileById(Long fileId) {
        return fileMapper.selectByPrimaryKey(fileId);
    }
}
