package com.gw.game.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 平台游戏关联表
 * @TableName plantform_game
 */
@TableName(value ="plantform_game")
public class PlantformGame implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 平台ID
     */
    private Long plantformId;

    /**
     * 游戏ID
     */
    private Long gameId;

    /**
     * 状态（0未启用，1启用）
     */
    private Integer status;

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
     * 平台ID
     */
    public Long getPlantformId() {
        return plantformId;
    }

    /**
     * 平台ID
     */
    public void setPlantformId(Long plantformId) {
        this.plantformId = plantformId;
    }

    /**
     * 游戏ID
     */
    public Long getGameId() {
        return gameId;
    }

    /**
     * 游戏ID
     */
    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    /**
     * 状态（0未启用，1启用）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态（0未启用，1启用）
     */
    public void setStatus(Integer status) {
        this.status = status;
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
        PlantformGame other = (PlantformGame) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPlantformId() == null ? other.getPlantformId() == null : this.getPlantformId().equals(other.getPlantformId()))
            && (this.getGameId() == null ? other.getGameId() == null : this.getGameId().equals(other.getGameId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
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
        result = prime * result + ((getPlantformId() == null) ? 0 : getPlantformId().hashCode());
        result = prime * result + ((getGameId() == null) ? 0 : getGameId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
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
        sb.append(", plantformId=").append(plantformId);
        sb.append(", gameId=").append(gameId);
        sb.append(", status=").append(status);
        sb.append(", creator=").append(creator);
        sb.append(", updater=").append(updater);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}