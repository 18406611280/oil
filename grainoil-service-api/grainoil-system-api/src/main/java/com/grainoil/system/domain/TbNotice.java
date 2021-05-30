package com.grainoil.system.domain;

import com.grainoil.common.core.domain.BaseEntity;

import java.util.Date;

public class TbNotice extends BaseEntity {
    private static final long   serialVersionUID = 1L;
    /**
    * 公告ID
    */
    private Long noticeId;

    /**
    * 公告标题名称
    */
    private String noticeTitle;

    /**
    * 公告模块(数字字典)
    */
    private String noticeType;

    /**
    * 公告内容id
    */
    private Long noticeContentId;

    /**
    * 是否公开(1公开 0 不公开)
    */
    private String open;

    /**
    * 公告状态（1已发布 0草稿）
    */
    private String state;

    /**
    * 发布者id
    */
    private Long publishId;

    /**
    * 发布者
    */
    private String publishBy;

    /**
    * 发布时间
    */
    private Date publishTime;

    /**
    * 删除标志（0代表存在 1代表删除）
    */
    private String delFlag;

    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    public Long getNoticeContentId() {
        return noticeContentId;
    }

    public void setNoticeContentId(Long noticeContentId) {
        this.noticeContentId = noticeContentId;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getPublishId() {
        return publishId;
    }

    public void setPublishId(Long publishId) {
        this.publishId = publishId;
    }

    public String getPublishBy() {
        return publishBy;
    }

    public void setPublishBy(String publishBy) {
        this.publishBy = publishBy;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}