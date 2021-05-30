package com.grainoil.dfs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grainoil.common.constant.Constants;
import com.grainoil.common.core.controller.BaseController;
import com.grainoil.system.domain.TbFile;
import com.grainoil.system.feign.RemoteFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.grainoil.common.core.domain.R;
import com.grainoil.common.utils.StringUtils;
import com.grainoil.common.utils.file.FileUploadUtils;
import com.grainoil.common.utils.file.FileUtils;
import com.grainoil.dfs.config.DfsConfig;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * 通用请求处理
 * 
 * @author grainoil
 */
@Slf4j
@RestController
@Api("文件上传下载")
public class FileController extends BaseController {
    @Autowired
    private DfsConfig dfsConfig;

    @Autowired
    RemoteFileService fileService;

//    /**
//     * 通用下载请求(原先)
//     *
//     * @param fileName 文件名称
//     * @param delete 是否删除
//     */
//    @GetMapping("download")
//    public void download(String fileName, Boolean delete, HttpServletResponse response, HttpServletRequest request)
//    {
//        try
//        {
//            if (!FileUtils.isValidFilename(fileName))
//            {
//                throw new Exception(StringUtils.format("文件名称({})非法，不允许下载。 ", fileName));
//            }
//            String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("_") + 1);
//            String filePath = dfsConfig.getPath() + "2021/04/28/" + fileName;
//            response.setCharacterEncoding("utf-8");
//            response.setContentType("multipart/form-data");
//            response.setHeader("Content-Disposition",
//                    "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, realFileName));
//            FileUtils.writeBytes(filePath, response.getOutputStream());
//            if (delete)
//            {
//                FileUtils.deleteFile(filePath);
//            }
//        }
//        catch (Exception e)
//        {
//            log.error("下载文件失败", e);
//        }
//    }

    /**
     * 通用下载请求
     *
     * @param fileId 文件id
     */
    @GetMapping("download")
    public void download(Long fileId, HttpServletResponse response, HttpServletRequest request) {
        try {
            TbFile tbFile = fileService.findFileById(fileId);
            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition", "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, tbFile.getFileName()));
//            FileUtils.writeBytes(filePath, response.getOutputStream());
        } catch (Exception e) {
            log.error("下载文件失败", e);
        }
    }

    /**
     * 通用上传请求
     */
    @ApiOperation("文件上传")
    @ApiImplicitParam(name = "file", value = "文件信息(type='file')", required = true)
    @PostMapping("upload")
    public R upload(MultipartFile file) {
        try {
            // 上传文件路径
            String filePath = dfsConfig.getPath();
            // 上传并返回上传信息
            Map<String, String> map = FileUploadUtils.upload(filePath, file);
            TbFile tbFile = new TbFile();
            tbFile.setFileName(map.get("fileName"));
            tbFile.setFileSuffix(map.get("extension"));
            tbFile.setUrl(map.get("url"));
            tbFile.setCreateId(getCurrentUserId());
            tbFile.setCreateBy(getLoginName());
            Map<String, Object> resultMap = fileService.insert(tbFile);
            if ((Integer) resultMap.get("insert") > 0) {
                return R.ok().put("fileName", tbFile.getFileName())
                        .put("url", tbFile.getUrl())
                        .put("id", resultMap.get("id"))
                        .put("show", "/dfs" + Constants.RESOURCE_PREFIX);
            } else {
                return R.error("上传文件失败");
            }
        } catch (Exception e) {
            log.error("上传文件失败", e);
            return R.error(e.getMessage());
        }
    }
}