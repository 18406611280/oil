package com.grainoil.system.domain;

import com.grainoil.common.core.domain.BaseEntity;

public class TbVariety extends BaseEntity {
    private static final long   serialVersionUID = 1L;
    /**
    * 粮油品种id
    */
    private Long varietyId;

    /**
    * 粮油名称
    */
    private String varietyName;

    /**
    * 拼音简写
    */
    private String varietyShortname;

    /**
    * 最低库存要求(%)
    */
    private Double percent;

    /**
     * 轮换时最高库存要求(%)
     */
    private Double rotationPercent;
    /**
    * 核定承储周期(月)
    */
    private Long months;

    /**
     * 父类id
     */
    private Long parentId;

    /**
    * 转换品种id
    */
    private Long transformId;

    /**
    * 品种间转换比率
    */
    private Double transformPercent;

    /**
    * 状态(0正常 1停用)
    */
    private String varietyState;

    /**
    * 删除标志（0代表存在 1代表删除）
    */
    private String delFlag;

    public TbVariety() {

    }

    public TbVariety(Long varietyId, String varietyName) {
        this.varietyId = varietyId;
        this.varietyName = varietyName;
    }

    public Long getVarietyId() {
        return varietyId;
    }

    public void setVarietyId(Long varietyId) {
        this.varietyId = varietyId;
    }

    public String getVarietyName() {
        return varietyName;
    }

    public void setVarietyName(String varietyName) {
        this.varietyName = varietyName;
    }

    public String getVarietyShortname() {
        return varietyShortname;
    }

    public void setVarietyShortname(String varietyShortname) {
        this.varietyShortname = varietyShortname;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public Long getTransformId() {
        return transformId;
    }

    public void setTransformId(Long transformId) {
        this.transformId = transformId;
    }

    public Double getTransformPercent() {
        return transformPercent;
    }

    public void setTransformPercent(Double transformPercent) {
        this.transformPercent = transformPercent;
    }

    public String getVarietyState() {
        return varietyState;
    }

    public void setVarietyState(String varietyState) {
        this.varietyState = varietyState;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public Long getMonths() {
        return months;
    }

    public void setMonths(Long months) {
        this.months = months;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Double getRotationPercent() {
        return rotationPercent;
    }

    public void setRotationPercent(Double rotationPercent) {
        this.rotationPercent = rotationPercent;
    }
}