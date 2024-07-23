package com.gw.game.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gw.base.entity.BaseEntity;
import icu.mhb.mybatisplus.plugln.annotations.JoinField;
import lombok.Data;
import org.apache.ibatis.annotations.Many;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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