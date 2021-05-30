package com.grainoil.system.domain;

import com.grainoil.common.core.domain.BaseEntity;

public class TbCompanyStorage extends BaseEntity {
    private static final long   serialVersionUID = 1L;
    /**
    * 主键id
    */
    private Long id;

    /**
    * 公司id
    */
    private Long organizeId;

    /**
    * 存储id
    */
    private Long storeId;

    /**
    * 存储类型(1.库,2.仓,3.堆)
    */
    private String storeType;

    /**
    * 删除标志（0代表存在 1代表删除）
    */
    private String delFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrganizeId() {
        return organizeId;
    }

    public void setOrganizeId(Long organizeId) {
        this.organizeId = organizeId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

}