package com.grainoil.system.domain;

import java.io.Serializable;
import java.util.Date;

public class TbInWarehouseDetailedCheck implements Serializable {

    private static final long   serialVersionUID = 1L;

    /**
    * id
    */
    private Long id;

    /**
    * 出入仓类型
    */
    private String type;

    /**
    * 出入仓单id
    */
    private Long inOrOutId;

    /**
    * 审批状态
    */
    private String approvalState;

    /**
    * 审批人Id
    */
    private Long approvalId;

    /**
     * 审批人名称
     */
    private String approvalName;

    /**
    * 审批时间
    */
    private Date approvalTime;

    /**
    * 审批结果
    */
    private String approvalResult;

    /**
    * 审批意见
    */
    private String approvalOpinion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getInOrOutId() {
        return inOrOutId;
    }

    public void setInOrOutId(Long inOrOutId) {
        this.inOrOutId = inOrOutId;
    }

    public String getApprovalState() {
        return approvalState;
    }

    public void setApprovalState(String approvalState) {
        this.approvalState = approvalState;
    }

    public Long getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(Long approvalId) {
        this.approvalId = approvalId;
    }

    public Date getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(Date approvalTime) {
        this.approvalTime = approvalTime;
    }

    public String getApprovalResult() {
        return approvalResult;
    }

    public void setApprovalResult(String approvalResult) {
        this.approvalResult = approvalResult;
    }

    public String getApprovalOpinion() {
        return approvalOpinion;
    }

    public void setApprovalOpinion(String approvalOpinion) {
        this.approvalOpinion = approvalOpinion;
    }

    public String getApprovalName() {
        return approvalName;
    }

    public void setApprovalName(String approvalName) {
        this.approvalName = approvalName;
    }
}