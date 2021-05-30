package com.grainoil.system.domain;

import com.grainoil.common.core.domain.BaseEntity;
import com.grainoil.system.domain.vo.point_management.StorehouseGet;

import java.util.Date;

public class TbStorehouse extends BaseEntity {
    private static final long   serialVersionUID = 1L;
    /**
    * 仓房id,仓房编号
    */
    private Long storehouseId;

    /**
     * 仓房名称
     */
    private String storehouseName;

    /**
     * 仓房编码
     */
    private String storehouseCode;

    /**
     * 仓房类型(数字字典)
     */
    private String storehouseType;

    /**
     * 经度
     */
    private Double storehouseLongitude;

    /**
     * 纬度
     */
    private Double storehouseLatitude;

    /**
     * 交付使用日期
     */
    private String deliveryDate;

    /**
     * 仓房设计容量
     */
    private Double storehouseCapacity;

    /**
     * 状态(0正常 1停用)
     */
    private String storehouseState;

    /**
     * 仓房面积
     */
    private Double storehouseArea;

    /**
     * 建设年份
     */
    private Long storehouseYear;

    /**
     * 图片id
     */
    private Long storehouseImg;

    /**
     * 所属粮库id
     */
    private Long grainDepotId;

    /**
     * 启用时间
     */
    private Date startTime;

    /**
     * 停用时间
     */
    private Date blockUpTime;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private String delFlag;

    public Long getStorehouseId() {
        return storehouseId;
    }

    public void setStorehouseId(Long storehouseId) {
        this.storehouseId = storehouseId;
    }

    public String getStorehouseName() {
        return storehouseName;
    }

    public void setStorehouseName(String storehouseName) {
        this.storehouseName = storehouseName;
    }

    public String getStorehouseCode() {
        return storehouseCode;
    }

    public void setStorehouseCode(String storehouseCode) {
        this.storehouseCode = storehouseCode;
    }

    public Double getStorehouseCapacity() {
        return storehouseCapacity;
    }

    public void setStorehouseCapacity(Double storehouseCapacity) {
        this.storehouseCapacity = storehouseCapacity;
    }

    public String getStorehouseState() {
        return storehouseState;
    }

    public void setStorehouseState(String storehouseState) {
        this.storehouseState = storehouseState;
    }

    public Double getStorehouseArea() {
        return storehouseArea;
    }

    public void setStorehouseArea(Double storehouseArea) {
        this.storehouseArea = storehouseArea;
    }

    public Long getStorehouseYear() {
        return storehouseYear;
    }

    public void setStorehouseYear(Long storehouseYear) {
        this.storehouseYear = storehouseYear;
    }

    public Long getStorehouseImg() {
        return storehouseImg;
    }

    public void setStorehouseImg(Long storehouseImg) {
        this.storehouseImg = storehouseImg;
    }

    public Long getGrainDepotId() {
        return grainDepotId;
    }

    public void setGrainDepotId(Long grainDepotId) {
        this.grainDepotId = grainDepotId;
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

    public String getStorehouseType() {
        return storehouseType;
    }

    public void setStorehouseType(String storehouseType) {
        this.storehouseType = storehouseType;
    }

    public Double getStorehouseLongitude() {
        return storehouseLongitude;
    }

    public void setStorehouseLongitude(Double storehouseLongitude) {
        this.storehouseLongitude = storehouseLongitude;
    }

    public Double getStorehouseLatitude() {
        return storehouseLatitude;
    }

    public void setStorehouseLatitude(Double storehouseLatitude) {
        this.storehouseLatitude = storehouseLatitude;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public StorehouseGet getStorehouse() {
        StorehouseGet get = new StorehouseGet();
        get.setStorehouseId(getStorehouseId());
        get.setStorehouseCode(getStorehouseCode());
        get.setStorehouseCapacity(getStorehouseCapacity());
        get.setStorehouseArea(getStorehouseArea());
        get.setStorehouseYear(getStorehouseYear());
        get.setStorehouseType(getStorehouseType());
        return get;
    }
}