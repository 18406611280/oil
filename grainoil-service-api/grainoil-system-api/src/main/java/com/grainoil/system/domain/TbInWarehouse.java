package com.grainoil.system.domain;

import com.grainoil.common.core.domain.BaseEntity;
import com.grainoil.system.domain.vo.in_warehouse.InWarehouseVo;

import java.util.Date;
import java.util.List;

public class TbInWarehouse extends BaseEntity {

    private static final long   serialVersionUID = 1L;

    /**
    * id
    */
    private Long id;

    /**
    * 入仓单编号
    */
    private String inWarehouseCode;

    /**
    * 市(区)粮管中心id(粮权)
    */
    private Long grainOrganizeId;

    /**
    * 粮管中心名称
    */
    private String grainOrganizeName;

    /**
    * 承储企业
    */
    private String organizeName;

    /**
    * 承储企业id
    */
    private Long organizeId;

    /**
    * 入库类型
    */
    private String warehousingType;

    /**
    * 计划批次号(存储合同、轮入计划)
    */
    private String batchCode;

    /**
    * 计划批次id(存储合同、轮入计划)
    */
    private Long batchId;

    /**
    * 仓房id
    */
    private Long storehouseId;

    /**
    * 仓房
    */
    private String storehouseName;

    /**
    * 粮库id
    */
    private Long grainDepotId;

    /**
    * 粮库
    */
    private String grainDepotName;

    /**
    * 粮食等级
    */
    private String grade;

    /**
     * 粮食品种id
     */
    private Long varietyId;

    /**
    * 粮食品种
    */
    private String variety;

    /**
    * 小品种_新
    */
    private String childVarieties;

    /**
    * 数量
    */
    private Double quantity;

    /**
    * 购入价格
    */
    private Double price;

    /**
    * 产地
    */
    private String producingArea;

    /**
    * 产地_省
    */
    private String producingProvince;

    /**
    * 产地_市
    */
    private String producingCity;

    /**
    * 国家
    */
    private String country;

    /**
    * 包装方式
    */
    private String packing;

    /**
    * 包装材料
    */
    private String packingMaterial;

    /**
    * 包数
    */
    private Long packingNumber;

    /**
    * 生产年份
    */
    private String particularYear;

    /**
     * 申请时间
     */
    private Date applyTime;

    /**
    * 状态
    */
    private String state;

    /**
    * 是否删除
    */
    private String delFlag;

    /**
     * 入仓单明细
     */
    private List<TbInWarehouseDetailed> detailed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInWarehouseCode() {
        return inWarehouseCode;
    }

    public void setInWarehouseCode(String inWarehouseCode) {
        this.inWarehouseCode = inWarehouseCode;
    }

    public Long getGrainOrganizeId() {
        return grainOrganizeId;
    }

    public void setGrainOrganizeId(Long grainOrganizeId) {
        this.grainOrganizeId = grainOrganizeId;
    }

    public String getGrainOrganizeName() {
        return grainOrganizeName;
    }

    public void setGrainOrganizeName(String grainOrganizeName) {
        this.grainOrganizeName = grainOrganizeName;
    }

    public String getOrganizeName() {
        return organizeName;
    }

    public void setOrganizeName(String organizeName) {
        this.organizeName = organizeName;
    }

    public Long getOrganizeId() {
        return organizeId;
    }

    public void setOrganizeId(Long organizeId) {
        this.organizeId = organizeId;
    }

    public String getWarehousingType() {
        return warehousingType;
    }

    public void setWarehousingType(String warehousingType) {
        this.warehousingType = warehousingType;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Long getVarietyId() {
        return varietyId;
    }

    public void setVarietyId(Long varietyId) {
        this.varietyId = varietyId;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getChildVarieties() {
        return childVarieties;
    }

    public void setChildVarieties(String childVarieties) {
        this.childVarieties = childVarieties;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProducingArea() {
        return producingArea;
    }

    public void setProducingArea(String producingArea) {
        this.producingArea = producingArea;
    }

    public String getProducingProvince() {
        return producingProvince;
    }

    public void setProducingProvince(String producingProvince) {
        this.producingProvince = producingProvince;
    }

    public String getProducingCity() {
        return producingCity;
    }

    public void setProducingCity(String producingCity) {
        this.producingCity = producingCity;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing;
    }

    public String getPackingMaterial() {
        return packingMaterial;
    }

    public void setPackingMaterial(String packingMaterial) {
        this.packingMaterial = packingMaterial;
    }

    public Long getPackingNumber() {
        return packingNumber;
    }

    public void setPackingNumber(Long packingNumber) {
        this.packingNumber = packingNumber;
    }

    public String getParticularYear() {
        return particularYear;
    }

    public void setParticularYear(String particularYear) {
        this.particularYear = particularYear;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public List<TbInWarehouseDetailed> getDetailed() {
        return detailed;
    }

    public void setDetailed(List<TbInWarehouseDetailed> detailed) {
        this.detailed = detailed;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public InWarehouseVo getInWarehouse() {
        InWarehouseVo vo = new InWarehouseVo();
        vo.setId(getId());
        vo.setInWarehouseCode(getInWarehouseCode());
        vo.setOrganizeName(getOrganizeName());
        vo.setOrganizeId(getOrganizeId());
        vo.setWarehousingType(getWarehousingType());
        vo.setBatchCode(getBatchCode());
        vo.setBatchId(getBatchId());
        vo.setStorehouseName(getStorehouseName());
        vo.setStorehouseId(getStorehouseId());
        vo.setGrade(getGrade());
        vo.setGrainDepotId(getGrainDepotId());
        vo.setGrainDepotName(getGrainDepotName());
        vo.setVariety(getVariety());
        vo.setVarietyId(getVarietyId());
        vo.setChildVarieties(getChildVarieties());
        vo.setQuantity(getQuantity());
        vo.setPrice(getPrice());
        vo.setProducingArea(getProducingArea());
        vo.setProducingProvince(getProducingProvince());
        vo.setCountry(getCountry());
        vo.setPacking(getPacking());
        vo.setPackingMaterial(getPackingMaterial());
        vo.setPackingNumber(getPackingNumber());
        vo.setParticularYear(getParticularYear());
        vo.setRemark(getRemark());
        return vo;
    }
}