package com.gw.game.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gw.base.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 商户游戏玩法关联表
 * @TableName plantform_merchant_game_play
 */
@Data
@TableName(value ="plantform_merchant_game_play")
public class PlantformMerchantGamePlayEntity extends BaseEntity {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 平台商户ID
     */
    private Long merchantId;

    /**
     * 游戏ID
     */
    private Long gameId;

    /**
     * 游戏玩法ID
     */
    private Long gamePlayId;

    /**
     * 状态（0未启用，1启用）
     */
    private Integer status;
}