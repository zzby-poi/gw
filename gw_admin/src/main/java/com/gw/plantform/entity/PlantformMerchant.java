package com.gw.plantform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 平台商户信息
 * @TableName plantform_merchant
 */
@TableName(value ="plantform_merchant")
public class PlantformMerchant implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 所属平台ID
     */
    private Long plantformId;

    /**
     * 商户名称
     */
    private String merchantName;

    /**
     * code
     */
    private String code;

    /**
     * token校验地址
     */
    private String tokenUrl;

    /**
     * 状态（1正常，0冻结）
     */
    private Integer status;

    /**
     * 币种
     */
    private String currency;

    /**
     * 商户会员用户名前缀
     */
    private String prefix;

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
     * 所属平台ID
     */
    public Long getPlantformId() {
        return plantformId;
    }

    /**
     * 所属平台ID
     */
    public void setPlantformId(Long plantformId) {
        this.plantformId = plantformId;
    }

    /**
     * 商户名称
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * 商户名称
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    /**
     * code
     */
    public String getCode() {
        return code;
    }

    /**
     * code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * token校验地址
     */
    public String getTokenUrl() {
        return tokenUrl;
    }

    /**
     * token校验地址
     */
    public void setTokenUrl(String tokenUrl) {
        this.tokenUrl = tokenUrl;
    }

    /**
     * 状态（1正常，0冻结）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态（1正常，0冻结）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 币种
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * 币种
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * 商户会员用户名前缀
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * 商户会员用户名前缀
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
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
        PlantformMerchant other = (PlantformMerchant) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPlantformId() == null ? other.getPlantformId() == null : this.getPlantformId().equals(other.getPlantformId()))
            && (this.getMerchantName() == null ? other.getMerchantName() == null : this.getMerchantName().equals(other.getMerchantName()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getTokenUrl() == null ? other.getTokenUrl() == null : this.getTokenUrl().equals(other.getTokenUrl()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCurrency() == null ? other.getCurrency() == null : this.getCurrency().equals(other.getCurrency()))
            && (this.getPrefix() == null ? other.getPrefix() == null : this.getPrefix().equals(other.getPrefix()))
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
        result = prime * result + ((getMerchantName() == null) ? 0 : getMerchantName().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getTokenUrl() == null) ? 0 : getTokenUrl().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCurrency() == null) ? 0 : getCurrency().hashCode());
        result = prime * result + ((getPrefix() == null) ? 0 : getPrefix().hashCode());
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
        sb.append(", merchantName=").append(merchantName);
        sb.append(", code=").append(code);
        sb.append(", tokenUrl=").append(tokenUrl);
        sb.append(", status=").append(status);
        sb.append(", currency=").append(currency);
        sb.append(", prefix=").append(prefix);
        sb.append(", creator=").append(creator);
        sb.append(", updater=").append(updater);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}