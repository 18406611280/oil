package com.grainoil.system.domain;

import java.io.Serializable;
import java.util.Date;

public class TbFile implements Serializable {

    private static final long   serialVersionUID = 1L;
    /**
    * 文件id
    */
    private Long fileId;

    /**
    * 文件名
    */
    private String fileName;

    /**
    * 文件类型
    */
    private String fileType;

    /**
    * 文件格式
    */
    private String fileFormat;

    /**
    * 文件后缀名
    */
    private String fileSuffix;

    /**
    * URL地址
    */
    private String url;

    /**
    * 上传人id
    */
    private Long createId;

    /**
    * 上传人
    */
    private String createBy;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 上传标志
    */
    private String uploadSign;

    /**
    * 状态
    */
    private String state;

    /**
    * 备注
    */
    private String remark;

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUploadSign() {
        return uploadSign;
    }

    public void setUploadSign(String uploadSign) {
        this.uploadSign = uploadSign;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}