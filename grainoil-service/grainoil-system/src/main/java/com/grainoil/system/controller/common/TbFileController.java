package com.grainoil.system.controller.common;

import com.grainoil.common.core.controller.BaseController;
import com.grainoil.system.domain.TbFile;
import com.grainoil.system.service.ITbFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("file")
public class TbFileController extends BaseController {

    @Autowired
    ITbFileService tbFileService;

    /**
     * 数据库添加上传文件信息
     *
     * @param tbFile 文件信息
     * @return 结果
     */
    @PostMapping("insert")
    public Map<String, Object> insert(@RequestBody TbFile tbFile) {
        Integer insert = tbFileService.insert(tbFile);
        Map<String, Object> map = new HashMap<>();
        map.put("insert", insert);
        map.put("id", tbFile.getFileId());
        return map;
    }

    /**
     * 根据文件id查询文件信息
     *
     * @param fileId 文件id
     * @return 文件信息
     */
    @GetMapping("file/find/{fileId}")
    public TbFile findFileById(@PathVariable("fileId") Long fileId) {
        return tbFileService.findFileById(fileId);
    }
}
