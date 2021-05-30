package com.grainoil.system.domain;

import com.grainoil.common.core.domain.BaseEntity;

public class TbManStorage extends BaseEntity {
    private static final long   serialVersionUID = 1L;
    /**
    * 主键id
    */
    private Long id;

    /**
    * 负责人id
    */
    private Long personId;

    /**
    * 储物单位id
    */
    private Long storeId;

    /**
    * 储物类型(1粮库 2仓房 3堆位)
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

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
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