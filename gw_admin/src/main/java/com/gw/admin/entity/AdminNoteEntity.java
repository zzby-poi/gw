package com.gw.admin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 公告信息表
 * @TableName admin_note
 */
@TableName(value ="admin_note")
public class AdminNoteEntity implements Serializable {
    /**
     * 
     */
    @TableId
    private Long id;

    /**
     * 公告标题
     */
    private String title;

    /**
     * 公告内容
     */
    private String content;

    /**
     * 商户ID（针对所有商户时为-1）
     */
    private Long merchantId;

    /**
     * 审核状态（0待审核；1已发布；2审核驳回；3已取消）
     */
    private Integer aduitStatus;

    /**
     * 审核人ID
     */
    private Long aduitUserId;

    /**
     * 审核时间
     */
    private Date aduitTime;

    /**
     * 驳回原因(驳回时必填)
     */
    private String rejectReason;

    /**
     * 是否置顶（0否，1是）
     */
    private Integer isTop;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 更新人
     */
    private String updater;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 修改时间
     */
    private Date updatedAt;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 公告标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 公告标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 公告内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 公告内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 商户ID（针对所有商户时为-1）
     */
    public Long getMerchantId() {
        return merchantId;
    }

    /**
     * 商户ID（针对所有商户时为-1）
     */
    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * 审核状态（0待审核；1已发布；2审核驳回；3已取消）
     */
    public Integer getAduitStatus() {
        return aduitStatus;
    }

    /**
     * 审核状态（0待审核；1已发布；2审核驳回；3已取消）
     */
    public void setAduitStatus(Integer aduitStatus) {
        this.aduitStatus = aduitStatus;
    }

    /**
     * 审核人ID
     */
    public Long getAduitUserId() {
        return aduitUserId;
    }

    /**
     * 审核人ID
     */
    public void setAduitUserId(Long aduitUserId) {
        this.aduitUserId = aduitUserId;
    }

    /**
     * 审核时间
     */
    public Date getAduitTime() {
        return aduitTime;
    }

    /**
     * 审核时间
     */
    public void setAduitTime(Date aduitTime) {
        this.aduitTime = aduitTime;
    }

    /**
     * 驳回原因(驳回时必填)
     */
    public String getRejectReason() {
        return rejectReason;
    }

    /**
     * 驳回原因(驳回时必填)
     */
    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    /**
     * 是否置顶（0否，1是）
     */
    public Integer getIsTop() {
        return isTop;
    }

    /**
     * 是否置顶（0否，1是）
     */
    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    /**
     * 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 更新人
     */
    public String getUpdater() {
        return updater;
    }

    /**
     * 更新人
     */
    public void setUpdater(String updater) {
        this.updater = updater;
    }

    /**
     * 创建时间
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * 创建时间
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 修改时间
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * 修改时间
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AdminNoteEntity other = (AdminNoteEntity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getMerchantId() == null ? other.getMerchantId() == null : this.getMerchantId().equals(other.getMerchantId()))
            && (this.getAduitStatus() == null ? other.getAduitStatus() == null : this.getAduitStatus().equals(other.getAduitStatus()))
            && (this.getAduitUserId() == null ? other.getAduitUserId() == null : this.getAduitUserId().equals(other.getAduitUserId()))
            && (this.getAduitTime() == null ? other.getAduitTime() == null : this.getAduitTime().equals(other.getAduitTime()))
            && (this.getRejectReason() == null ? other.getRejectReason() == null : this.getRejectReason().equals(other.getRejectReason()))
            && (this.getIsTop() == null ? other.getIsTop() == null : this.getIsTop().equals(other.getIsTop()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getUpdater() == null ? other.getUpdater() == null : this.getUpdater().equals(other.getUpdater()))
            && (this.getCreatedAt() == null ? other.getCreatedAt() == null : this.getCreatedAt().equals(other.getCreatedAt()))
            && (this.getUpdatedAt() == null ? other.getUpdatedAt() == null : this.getUpdatedAt().equals(other.getUpdatedAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getMerchantId() == null) ? 0 : getMerchantId().hashCode());
        result = prime * result + ((getAduitStatus() == null) ? 0 : getAduitStatus().hashCode());
        result = prime * result + ((getAduitUserId() == null) ? 0 : getAduitUserId().hashCode());
        result = prime * result + ((getAduitTime() == null) ? 0 : getAduitTime().hashCode());
        result = prime * result + ((getRejectReason() == null) ? 0 : getRejectReason().hashCode());
        result = prime * result + ((getIsTop() == null) ? 0 : getIsTop().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getUpdater() == null) ? 0 : getUpdater().hashCode());
        result = prime * result + ((getCreatedAt() == null) ? 0 : getCreatedAt().hashCode());
        result = prime * result + ((getUpdatedAt() == null) ? 0 : getUpdatedAt().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", content=").append(content);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", aduitStatus=").append(aduitStatus);
        sb.append(", aduitUserId=").append(aduitUserId);
        sb.append(", aduitTime=").append(aduitTime);
        sb.append(", rejectReason=").append(rejectReason);
        sb.append(", isTop=").append(isTop);
        sb.append(", creator=").append(creator);
        sb.append(", updater=").append(updater);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}