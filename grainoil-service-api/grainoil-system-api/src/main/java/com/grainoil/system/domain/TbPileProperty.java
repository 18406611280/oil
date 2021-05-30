package com.grainoil.system.domain;

import com.grainoil.common.core.domain.BaseEntity;

import java.util.Date;

public class TbPileProperty extends BaseEntity {

    public static final long serialVersionUID = 1L;

    /**
    * id
    */
    private Long pileId;

    /**
    * 父堆Id
    */
    private Long parentId;

    /**
    * 包装方式
    */
    private String packMethod;

    /**
    * 包装材料
    */
    private String packMaterials;

    /**
    * 袋数
    */
    private Long packNum;

    /**
    * 状态
    */
    private String pileState;

    /**
    * 启用时间
    */
    private Date startTime;

    /**
    * 停用时间
    */
    private Date blockUpTime;

    /**
    * 是否删除
    */
    private String delFlag;

    public Long getPileId() {
        return pileId;
    }

    public void setPileId(Long pileId) {
        this.pileId = pileId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getPackMethod() {
        return packMethod;
    }

    public void setPackMethod(String packMethod) {
        this.packMethod = packMethod;
    }

    public String getPackMaterials() {
        return packMaterials;
    }

    public void setPackMaterials(String packMaterials) {
        this.packMaterials = packMaterials;
    }

    public Long getPackNum() {
        return packNum;
    }

    public void setPackNum(Long packNum) {
        this.packNum = packNum;
    }

    public String getPileState() {
        return pileState;
    }

    public void setPileState(String pileState) {
        this.pileState = pileState;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getBlockUpTime() {
        return blockUpTime;
    }

    public void setBlockUpTime(Date blockUpTime) {
        this.blockUpTime = blockUpTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}