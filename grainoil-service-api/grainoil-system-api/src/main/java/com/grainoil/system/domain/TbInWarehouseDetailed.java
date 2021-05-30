package com.grainoil.system.domain;

import com.grainoil.common.core.domain.BaseEntity;
import com.grainoil.system.domain.vo.FileVo;

import java.util.Date;
import java.util.List;

public class TbInWarehouseDetailed extends BaseEntity {

    private static final long   serialVersionUID = 1L;
    /**
    * id
    */
    private Long id;

    /**
    * 入仓单id
    */
    private Long inWarehouseId;

    /**
    * 粮库id
    */
    private Long grainDepotId;

    /**
    * 粮库名称
    */
    private String grainDepotName;

    /**
    * 仓房id
    */
    private Long storehouseId;

    /**
    * 仓房名称
    */
    private String storehouseName;

    /**
    * 堆位id
    */
    private Long heapId;

    /**
    * 堆位名
    */
    private String heapName;

    /**
    * 子堆id
    */
    private Long childHeapId;

    /**
    * 子堆编号
    */
    private String childHeapCode;

    /**
    * 上次结余库存
    */
    private Double previousStock;

    /**
    * 入仓日期
    */
    private Date warehouseDate;

    /**
     * 包数
     */
    private Long numbers;

    /**
    * 当次入仓数量
    */
    private Double quantity;

    /**
    * 附件
    */
    private String enclosure;

    /**
    * 保管员id
    */
    private String custodianId;

    /**
    * 保管员
    */
    private String custodian;

    /**
    * 审核是否通过
    */
    private String isAudit;

    /**
    * 是否删除
    */
    private String delFlag;

    /**
     * 附件详情集合
     */
    private List<FileVo> fileVos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInWarehouseId() {
        return inWarehouseId;
    }

    public void setInWarehouseId(Long inWarehouseId) {
        this.inWarehouseId = inWarehouseId;
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

    public Long getHeapId() {
        return heapId;
    }

    public void setHeapId(Long heapId) {
        this.heapId = heapId;
    }

    public String getHeapName() {
        return heapName;
    }

    public void setHeapName(String heapName) {
        this.heapName = heapName;
    }

    public Long getChildHeapId() {
        return childHeapId;
    }

    public void setChildHeapId(Long childHeapId) {
        this.childHeapId = childHeapId;
    }

    public String getChildHeapCode() {
        return childHeapCode;
    }

    public void setChildHeapCode(String childHeapCode) {
        this.childHeapCode = childHeapCode;
    }

    public Double getPreviousStock() {
        return previousStock;
    }

    public void setPreviousStock(Double previousStock) {
        this.previousStock = previousStock;
    }

    public Date getWarehouseDate() {
        return warehouseDate;
    }

    public void setWarehouseDate(Date warehouseDate) {
        this.warehouseDate = warehouseDate;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure;
    }

    public String getCustodianId() {
        return custodianId;
    }

    public void setCustodianId(String custodianId) {
        this.custodianId = custodianId;
    }

    public String getCustodian() {
        return custodian;
    }

    public void setCustodian(String custodian) {
        this.custodian = custodian;
    }

    public String getIsAudit() {
        return isAudit;
    }

    public void setIsAudit(String isAudit) {
        this.isAudit = isAudit;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public List<FileVo> getFileVos() {
        return fileVos;
    }

    public void setFileVos(List<FileVo> fileVos) {
        this.fileVos = fileVos;
    }

    public Long getNumber() {
        return numbers;
    }

    public void setNumber(Long numbers) {
        this.numbers = numbers;
    }
}