package com.grainoil.system.domain;

import com.grainoil.common.core.domain.BaseEntity;

import java.util.Date;

public class TbPile extends BaseEntity {
    private static final long   serialVersionUID = 1L;
    /**
    * 堆位id,堆位编号
    */
    private Long pileId;

    /**
    * 堆位名称
    */
    private String pileName;

    /**
    * 堆位编号
    */
    private String pileCode;

    /**
    * 堆位大小
    */
    private Double pileCapacity;

    /**
    * 堆位类型(1粮食 2油罐)(数字字典)
    */
    private String pileType;

    /**
    * 状态(0正常 1停用)
    */
    private String pileState;

    /**
    * 图片id
    */
    private Long pileImg;

    /**
    * 所属仓房id
    */
    private Long storehouseId;

    /**
    * 启用时间
    */
    private Date startTime;

    /**
    * 停用时间
    */
    private Date blockUpTime;

    /**
     * 是否已分堆
     */
    private String isSplit;

    /**
    * 删除标志（0代表存在 1代表删除）
    */
    private String delFlag;

    public Long getPileId() {
        return pileId;
    }

    public void setPileId(Long pileId) {
        this.pileId = pileId;
    }

    public String getPileName() {
        return pileName;
    }

    public void setPileName(String pileName) {
        this.pileName = pileName;
    }

    public String getPileCode() {
        return pileCode;
    }

    public void setPileCode(String pileCode) {
        this.pileCode = pileCode;
    }

    public Double getPileCapacity() {
        return pileCapacity;
    }

    public void setPileCapacity(Double pileCapacity) {
        this.pileCapacity = pileCapacity;
    }

    public String getPileType() {
        return pileType;
    }

    public void setPileType(String pileType) {
        this.pileType = pileType;
    }

    public String getPileState() {
        return pileState;
    }

    public void setPileState(String pileState) {
        this.pileState = pileState;
    }

    public Long getPileImg() {
        return pileImg;
    }

    public void setPileImg(Long pileImg) {
        this.pileImg = pileImg;
    }

    public Long getStorehouseId() {
        return storehouseId;
    }

    public void setStorehouseId(Long storehouseId) {
        this.storehouseId = storehouseId;
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

    public String getIsSplit() {
        return isSplit;
    }

    public void setIsSplit(String isSplit) {
        this.isSplit = isSplit;
    }
}