package com.grainoil.system.domain;

import com.grainoil.common.core.domain.BaseEntity;

public class TbOrganize extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /**
     * 组织id
     */
    private Long organizeId;

    /**
     * 组织名称
     */
    private String organizeName;

    /**
     * 企业编码
     */
    private String organizeCode;

    /**
     * 统一社会信用代码
     */
    private String organizeCreditCode;

    /**
     * 企业性质(数字字典)
     */
    private String organizeProperty;

    /**
     * 地址
     */
    private String organizePosition;

    /**
     * 省
     */
    private String organizeProvince;

    /**
     * 市
     */
    private String organizeCity;

    /**
     * 所在行政区(数字字典)
     */
    private String organizeRegion;

    /**
     * 经度
     */
    private Double organizeLongitude;

    /**
     * 纬度
     */
    private Double organizeLatitude;

    /**
     * 状态(0正常 1停用)
     */
    private String organizeState;

    /**
     * 服务对象
     */
    private String organizeNote;

    /**
     * 组织类型
     */
    private String organizeType;

    /**
     * 组织管理员
     */
    private String organizeAdmin;

    /**
     * 法人代表
     */
    private String organizePerson;

    /**
     * 联系电话
     */
    private String organizePhonenumber;

    /**
     * 证件图片id或者logo的id
     */
    private Long organizeImg;

    /**
     * 营业执照附件id
     */
    private Long organizeAttachmentId;

    /**
     * 父节点id
     */
    private Long parentId;

    /**
     * 父节点集合
     */
    private String parents;

    /**
     * 是否粮库可选企业(1可选 0不可选)
     */
    private String isSelect;

    /**
     * 删除标志（0代表存在 1代表删除）
     */
    private String delFlag;

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

    public String getOrganizeCode() {
        return organizeCode;
    }

    public void setOrganizeCode(String organizeCode) {
        this.organizeCode = organizeCode;
    }

    public String getOrganizeCreditCode() {
        return organizeCreditCode;
    }

    public void setOrganizeCreditCode(String organizeCreditCode) {
        this.organizeCreditCode = organizeCreditCode;
    }

    public String getOrganizeProperty() {
        return organizeProperty;
    }

    public void setOrganizeProperty(String organizeProperty) {
        this.organizeProperty = organizeProperty;
    }

    public String getOrganizePosition() {
        return organizePosition;
    }

    public void setOrganizePosition(String organizePosition) {
        this.organizePosition = organizePosition;
    }

    public String getOrganizeProvince() {
        return organizeProvince;
    }

    public void setOrganizeProvince(String organizeProvince) {
        this.organizeProvince = organizeProvince;
    }

    public String getOrganizeCity() {
        return organizeCity;
    }

    public void setOrganizeCity(String organizeCity) {
        this.organizeCity = organizeCity;
    }

    public String getOrganizeRegion() {
        return organizeRegion;
    }

    public void setOrganizeRegion(String organizeRegion) {
        this.organizeRegion = organizeRegion;
    }

    public Double getOrganizeLongitude() {
        return organizeLongitude;
    }

    public void setOrganizeLongitude(Double organizeLongitude) {
        this.organizeLongitude = organizeLongitude;
    }

    public Double getOrganizeLatitude() {
        return organizeLatitude;
    }

    public void setOrganizeLatitude(Double organizeLatitude) {
        this.organizeLatitude = organizeLatitude;
    }

    public String getOrganizeState() {
        return organizeState;
    }

    public void setOrganizeState(String organizeState) {
        this.organizeState = organizeState;
    }

    public String getOrganizeNote() {
        return organizeNote;
    }

    public void setOrganizeNote(String organizeNote) {
        this.organizeNote = organizeNote;
    }

    public String getOrganizeType() {
        return organizeType;
    }

    public void setOrganizeType(String organizeType) {
        this.organizeType = organizeType;
    }

    public String getOrganizeAdmin() {
        return organizeAdmin;
    }

    public void setOrganizeAdmin(String organizeAdmin) {
        this.organizeAdmin = organizeAdmin;
    }

    public String getOrganizePerson() {
        return organizePerson;
    }

    public void setOrganizePerson(String organizePerson) {
        this.organizePerson = organizePerson;
    }

    public String getOrganizePhonenumber() {
        return organizePhonenumber;
    }

    public void setOrganizePhonenumber(String organizePhonenumber) {
        this.organizePhonenumber = organizePhonenumber;
    }

    public Long getOrganizeImg() {
        return organizeImg;
    }

    public void setOrganizeImg(Long organizeImg) {
        this.organizeImg = organizeImg;
    }

    public Long getOrganizeAttachmentId() {
        return organizeAttachmentId;
    }

    public void setOrganizeAttachmentId(Long organizeAttachmentId) {
        this.organizeAttachmentId = organizeAttachmentId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParents() {
        return parents;
    }

    public void setParents(String parents) {
        this.parents = parents;
    }

    public String getIsSelect() {
        return isSelect;
    }

    public void setIsSelect(String isSelect) {
        this.isSelect = isSelect;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}