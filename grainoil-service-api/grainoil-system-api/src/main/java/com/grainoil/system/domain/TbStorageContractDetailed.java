package com.grainoil.system.domain;

import java.io.Serializable;

public class TbStorageContractDetailed implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private Long id;

    /**
     * 储备合同id
     */
    private Long stroageContractId;

    /**
     * 粮库所在区id
     */
    private Long grainRegionId;

    /**
     * 粮库所在区名称
     */
    private String grainRegionName;

    /**
     * 粮库id
     */
    private Long grainDepotId;

    /**
     * 粮库名称
     */
    private String grainDepotName;

    /**
     * 粮食品种id
     */
    private Long varietyId;

    /**
     * 粮油品种名称
     */
    private String variety;

    /**
     * 存储数量
     */
    private Double quantity;

    /**
     * 核定成本,单位 元/吨
     */
    private Double price;

    /**
     * 备注
     */
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStroageContractId() {
        return stroageContractId;
    }

    public void setStroageContractId(Long stroageContractId) {
        this.stroageContractId = stroageContractId;
    }

    public Long getGrainRegionId() {
        return grainRegionId;
    }

    public void setGrainRegionId(Long grainRegionId) {
        this.grainRegionId = grainRegionId;
    }

    public String getGrainRegionName() {
        return grainRegionName;
    }

    public void setGrainRegionName(String grainRegionName) {
        this.grainRegionName = grainRegionName;
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

    public Long getVarietyId() {
        return varietyId;
    }

    public void setVarietyId(Long varietyId) {
        this.varietyId = varietyId;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }
}