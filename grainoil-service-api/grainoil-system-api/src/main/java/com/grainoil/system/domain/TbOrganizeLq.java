package com.grainoil.system.domain;

import com.grainoil.common.core.domain.BaseEntity;

public class TbOrganizeLq extends BaseEntity {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 企业Id
     */
    private Long organizeId;

    /**
     * 粮权组织Id（番禺区等）
     */
    private Long lqId;

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

    public Long getLqId() {
        return lqId;
    }

    public void setLqId(Long lqId) {
        this.lqId = lqId;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}