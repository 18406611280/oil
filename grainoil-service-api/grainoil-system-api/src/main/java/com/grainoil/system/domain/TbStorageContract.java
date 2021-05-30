package com.grainoil.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grainoil.common.core.domain.BaseEntity;
import com.grainoil.system.domain.vo.FileVo;

import java.util.Date;
import java.util.List;

public class TbStorageContract extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private Long id;

    /**
     * 合同编号
     */
    private String contractCode;

    /**
     * 合同名称
     */
    private String contractName;

    /**
     * 粮权所属市或者区id
     */
    private Long grainOwnerId;

    /**
     * 粮权所属市或者区名称
     */
    private String grainOwnerName;

    /**
     * 承储企业id
     */
    private Long organizeId;

    /**
     * 承储企业
     */
    private String organizeName;

    /**
     * 承储周期开始
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;

    /**
     * 承储周期结束
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    /**
     * 合同状态
     */
    private String contractState;

    /**
     * 合同附件id
     */
    private Long contractFileId;

    /**
     * 合同附件信息
     */
    private FileVo fileVo;

    /**
     * 是否删除
     */
    private String delFlag;

    /**
     * 中标时间
     */
    private Date contractDate;

    /**
     * 合同明细
     */
    private List<TbStorageContractDetailed> detailedList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public Long getGrainOwnerId() {
        return grainOwnerId;
    }

    public void setGrainOwnerId(Long grainOwnerId) {
        this.grainOwnerId = grainOwnerId;
    }

    public String getGrainOwnerName() {
        return grainOwnerName;
    }

    public void setGrainOwnerName(String grainOwnerName) {
        this.grainOwnerName = grainOwnerName;
    }

    public Long getOrganizeId() {
        return organizeId;
    }

    public void setOrganizeId(Long organizeId) {
        this.organizeId = organizeId;
    }

    public String getOrganizeName() {
        return organizeName;
    }

    public void setOrganizeName(String organizeName) {
        this.organizeName = organizeName;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getContractState() {
        return contractState;
    }

    public void setContractState(String contractState) {
        this.contractState = contractState;
    }

    public Long getContractFileId() {
        return contractFileId;
    }

    public void setContractFileId(Long contractFileId) {
        this.contractFileId = contractFileId;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public List<TbStorageContractDetailed> getDetailedList() {
        return detailedList;
    }

    public void setDetailedList(List<TbStorageContractDetailed> detailedList) {
        this.detailedList = detailedList;
    }

    public FileVo getFileVo() {
        return fileVo;
    }

    public void setFileVo(FileVo fileVo) {
        this.fileVo = fileVo;
    }
}