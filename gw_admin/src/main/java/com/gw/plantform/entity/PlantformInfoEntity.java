package com.gw.plantform.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gw.base.entity.BaseEntity;
import lombok.Data;

/**
 * 平台信息
 * @TableName plantform_info
 */
@Data
@TableName(value ="plantform_info")
public class PlantformInfoEntity extends BaseEntity {
    /**
     * 
     */
    @TableId
    private Long id;

    /**
     * 平台名称
     */
    private String platformName;

    /**
     * 平台类型
     */
    private Integer platformType;

    /**
     * token校验地址
     */
    private String tokenUrl;

    /**
     * 平台商提供
     */
    private String apiKey;

    /**
     * 状态（1正常，0冻结）
     */
    private Integer status;
}