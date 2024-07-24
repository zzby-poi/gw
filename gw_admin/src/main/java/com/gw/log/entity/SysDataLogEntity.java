package com.gw.log.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 系统数据操作日志表
 * @TableName sys_data_log
 */
@TableName(value ="sys_data_log")
public class SysDataLogEntity implements Serializable {
    /**
     * 
     */
    @TableId
    private Long id;

    /**
     * 操作名称
     */
    private String operate;

    /**
     * 请求IP
     */
    private String ip;

    /**
     * 数据变化
     */
    private String dataChange;

    /**
     * 访问路径
     */
    private String url;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新人
     */
    private String updater;

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
     * 操作名称
     */
    public String getOperate() {
        return operate;
    }

    /**
     * 操作名称
     */
    public void setOperate(String operate) {
        this.operate = operate;
    }

    /**
     * 请求IP
     */
    public String getIp() {
        return ip;
    }

    /**
     * 请求IP
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 数据变化
     */
    public String getDataChange() {
        return dataChange;
    }

    /**
     * 数据变化
     */
    public void setDataChange(String dataChange) {
        this.dataChange = dataChange;
    }

    /**
     * 访问路径
     */
    public String getUrl() {
        return url;
    }

    /**
     * 访问路径
     */
    public void setUrl(String url) {
        this.url = url;
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
        SysDataLogEntity other = (SysDataLogEntity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOperate() == null ? other.getOperate() == null : this.getOperate().equals(other.getOperate()))
            && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
            && (this.getDataChange() == null ? other.getDataChange() == null : this.getDataChange().equals(other.getDataChange()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreatedAt() == null ? other.getCreatedAt() == null : this.getCreatedAt().equals(other.getCreatedAt()))
            && (this.getUpdater() == null ? other.getUpdater() == null : this.getUpdater().equals(other.getUpdater()))
            && (this.getUpdatedAt() == null ? other.getUpdatedAt() == null : this.getUpdatedAt().equals(other.getUpdatedAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOperate() == null) ? 0 : getOperate().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getDataChange() == null) ? 0 : getDataChange().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreatedAt() == null) ? 0 : getCreatedAt().hashCode());
        result = prime * result + ((getUpdater() == null) ? 0 : getUpdater().hashCode());
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
        sb.append(", operate=").append(operate);
        sb.append(", ip=").append(ip);
        sb.append(", dataChange=").append(dataChange);
        sb.append(", url=").append(url);
        sb.append(", creator=").append(creator);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updater=").append(updater);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}