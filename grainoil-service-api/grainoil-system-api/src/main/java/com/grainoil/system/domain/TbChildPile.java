package com.grainoil.system.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TbChildPile implements Serializable {

    public static final long serialVersionUID = 1L;
    /**
    * id
    */
    private Long pileId;

    /**
    * 父堆Id
    */
    private Long parentId;

    /**
    * 堆位编码
    */
    private String pileCode;

    /**
    * 容量
    */
    private Double pileCapacity;

    /**
    * 备注
    */
    private String remark;

    /**
    * 状态
    */
    private String pileState;

    /**
    * 启用时间
    */
    private Date startTime;

    /**
    * 停用时间
    */
    private Date blockUpTime;

    /**
    * 是否删除
    */
    private String delFlag;

    /**
    * 创建id
    */
    private Long createId;

    /**
    * 创建人
    */
    private String createBy;

    /**
    * 创建日期
    */
    private Date createTime;

    /**
    * 更新人id
    */
    private Long updateId;

    /**
    * 更新人
    */
    private String updateBy;

    /**
    * 更新日期
    */
    private Date updateTime;

}