package com.grainoil.system.domain;

import com.grainoil.common.core.domain.BaseEntity;
import com.grainoil.system.domain.vo.point_management.GrainDepotGet;

import java.util.Date;

public class TbGrainDepot extends BaseEntity {
    private static final long   serialVersionUID = 1L;
    /**
     * 粮库id,粮库编号
     */
    private Long grainDepotId;

    /**
     * 粮库代码
     */
    private String provinceGrainDepotCode;

    /**
     * 粮库名称
     */
    private String grainDepotName;

    /**
     * 粮库简称
     */
    private String grainDepotShortname;

    /**
     * 粮库编码
     */
    private String grainDepotCode;

    /**
     * 建设年份
     */
    private Long createYear;

    /**
     * 所在省
     */
    private String grainDepotProvince;

    /**
     * 所在市
     */
    private String grainDepotCity;

    /**
     * 所在行政区(数字字典)
     */
    private String grainDepotRegion;

    /**
     * 经度
     */
    private Double grainDepotLongitude;

    /**
     * 纬度
     */
    private Double grainDepotLatitude;

    /**
     * 状态(0正常 1停用)
     */
    private String grainDepotState;

    /**
     * 图片id
     */
    private Long grainDepotImg;

    /**
     * 仓房设计总容量(吨)
     */
    private Double grainDepotCapacity;

    /**
     * 油罐设计总容量(吨)
     */
    private Double granaryOilSize;

    /**
     * 地址
     */
    private String grainDepotPosition;

    /**
     * 所属组织id
     */
    private Long belongId;

    /**
     * 组织名称
     */
    private String belongName;

    /**
     * 区所在粮管中心id
     */
    private Long centerId;

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

    /**
     * 有效仓容
     */
    private Double availableDepotCapacity;

    /**
     * 有效罐容
     */
    private Double availableOilSize;

    /**
     * 占地面积
     */
    private Double space;

    /**
     * 库区产权
     */
    private String propertyRight;

    /**
     * 库点行政区划代码
     */
    private String grainDepotRegionCode;

    public Long getGrainDepotId() {
        return grainDepotId;
    }

    public void setGrainDepotId(Long grainDepotId) {
        this.grainDepotId = grainDepotId;
    }

    public String getGrainDepotName() {
        return grainDepotName;
    }

    public void setGrainDepotName(String grainDepotName) {
        this.grainDepotName = grainDepotName;
    }

    public String getGrainDepotShortname() {
        return grainDepotShortname;
    }

    public void setGrainDepotShortname(String grainDepotShortname) {
        this.grainDepotShortname = grainDepotShortname;
    }

    public String getGrainDepotCode() {
        return grainDepotCode;
    }

    public void setGrainDepotCode(String grainDepotCode) {
        this.grainDepotCode = grainDepotCode;
    }

    public String getGrainDepotProvince() {
        return grainDepotProvince;
    }

    public void setGrainDepotProvince(String grainDepotProvince) {
        this.grainDepotProvince = grainDepotProvince;
    }

    public String getGrainDepotCity() {
        return grainDepotCity;
    }

    public void setGrainDepotCity(String grainDepotCity) {
        this.grainDepotCity = grainDepotCity;
    }

    public String getGrainDepotRegion() {
        return grainDepotRegion;
    }

    public void setGrainDepotRegion(String grainDepotRegion) {
        this.grainDepotRegion = grainDepotRegion;
    }

    public Double getGrainDepotLongitude() {
        return grainDepotLongitude;
    }

    public void setGrainDepotLongitude(Double grainDepotLongitude) {
        this.grainDepotLongitude = grainDepotLongitude;
    }

    public Double getGrainDepotLatitude() {
        return grainDepotLatitude;
    }

    public void setGrainDepotLatitude(Double grainDepotLatitude) {
        this.grainDepotLatitude = grainDepotLatitude;
    }

    public String getGrainDepotState() {
        return grainDepotState;
    }

    public void setGrainDepotState(String grainDepotState) {
        this.grainDepotState = grainDepotState;
    }

    public Long getGrainDepotImg() {
        return grainDepotImg;
    }

    public void setGrainDepotImg(Long grainDepotImg) {
        this.grainDepotImg = grainDepotImg;
    }

    public Double getGrainDepotCapacity() {
        return grainDepotCapacity;
    }

    public void setGrainDepotCapacity(Double grainDepotCapacity) {
        this.grainDepotCapacity = grainDepotCapacity;
    }

    public Double getGranaryOilSize() {
        return granaryOilSize;
    }

    public void setGranaryOilSize(Double granaryOilSize) {
        this.granaryOilSize = granaryOilSize;
    }

    public String getGrainDepotPosition() {
        return grainDepotPosition;
    }

    public void setGrainDepotPosition(String grainDepotPosition) {
        this.grainDepotPosition = grainDepotPosition;
    }

    public Long getBelongId() {
        return belongId;
    }

    public void setBelongId(Long belongId) {
        this.belongId = belongId;
    }

    public String getBelongName() {
        return belongName;
    }

    public void setBelongName(String belongName) {
        this.belongName = belongName;
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

    public Long getCenterId() {
        return centerId;
    }

    public void setCenterId(Long centerId) {
        this.centerId = centerId;
    }

    public Long getCreateYear() {
        return createYear;
    }

    public void setCreateYear(Long createYear) {
        this.createYear = createYear;
    }

    public String getProvinceGrainDepotCode() {
        return provinceGrainDepotCode;
    }

    public void setProvinceGrainDepotCode(String provinceGrainDepotCode) {
        this.provinceGrainDepotCode = provinceGrainDepotCode;
    }

    public Double getAvailableDepotCapacity() {
        return availableDepotCapacity;
    }

    public void setAvailableDepotCapacity(Double availableDepotCapacity) {
        this.availableDepotCapacity = availableDepotCapacity;
    }

    public Double getAvailableOilSize() {
        return availableOilSize;
    }

    public void setAvailableOilSize(Double availableOilSize) {
        this.availableOilSize = availableOilSize;
    }

    public Double getSpace() {
        return space;
    }

    public void setSpace(Double space) {
        this.space = space;
    }

    public String getPropertyRight() {
        return propertyRight;
    }

    public void setPropertyRight(String propertyRight) {
        this.propertyRight = propertyRight;
    }

    public String getGrainDepotRegionCode() {
        return grainDepotRegionCode;
    }

    public void setGrainDepotRegionCode(String grainDepotRegionCode) {
        this.grainDepotRegionCode = grainDepotRegionCode;
    }

    public GrainDepotGet getGrainDepot() {
        GrainDepotGet grainDepotGet = new GrainDepotGet();
        grainDepotGet.setGrainDepotId(getGrainDepotId());
        grainDepotGet.setGrainDepotName(getGrainDepotName());
        grainDepotGet.setBelongId(getBelongId());
        grainDepotGet.setBelongName(getBelongName());
        grainDepotGet.setGrainDepotRegion(getGrainDepotRegion());
        grainDepotGet.setRemark(getRemark());
        grainDepotGet.setCenterId(getCenterId());
        grainDepotGet.setGrainDepotCapacity(getGrainDepotCapacity());
        grainDepotGet.setGrainDepotPosition(getGrainDepotPosition());
        grainDepotGet.setGrainDepotLongitude(getGrainDepotLongitude());
        grainDepotGet.setGrainDepotLatitude(getGrainDepotLatitude());
        grainDepotGet.setGrainDepotCode(getGrainDepotCode());
        return grainDepotGet;
    }
}