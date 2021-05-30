package com.grainoil.common.core.domain;

import lombok.Data;

@Data
public class CurrentUser {

    /**
     * 用户id
     */
    private Long currentId;

    /**
     * 用户名
     */
    private String currentName;

    /**
     * 组织类型
     */
    private String organizeType;

    /**
     * 组织id
     */
    private Long organizeId;

    /**
     * 粮库id
     */
    private String organizeDepotId;

    /**
     * 粮权id
     */
    private Long lq;
}
