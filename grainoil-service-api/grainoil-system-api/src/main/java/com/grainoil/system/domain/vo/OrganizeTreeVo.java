package com.grainoil.system.domain.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 组织管理树结构
 */
@Data
public class OrganizeTreeVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;

    /**
     * 也是id
     */
    private String key;

    private List<OrganizeTreeVo> children;

//    public OrganizeTreeVo(String title, String key) {
//        this.title = title;
//        this.key = key;
//    }
}
