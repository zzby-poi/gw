package com.gw.plantform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gw.base.entity.BaseEntity;
import lombok.Data;

/**
 * 商户游戏关联表
 * @TableName plantform_merchant_game
 */
@Data
@TableName(value ="plantform_merchant_game")
public class PlantformMerchantGameEntity extends BaseEntity {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 商户ID
     */
    private Long merchantId;

    /**
     * 游戏ID
     */
    private Long gameId;

    /**
     * 状态（0未启用，1启用）
     */
    private Integer status;

}