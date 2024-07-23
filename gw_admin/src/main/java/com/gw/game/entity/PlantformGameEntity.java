package com.gw.game.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gw.base.entity.BaseEntity;
import lombok.Data;
/**
 * 平台游戏关联表
 * @TableName plantform_game
 */
@Data
@TableName(value ="plantform_game")
public class PlantformGameEntity extends BaseEntity {
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
}