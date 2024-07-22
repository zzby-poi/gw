package com.gw.game.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gw.base.entity.BaseEntity;
import lombok.Data;

/**
 * @author zzby
 * @version 创建时间： 2024/7/22 15:06
 */
@Data
@TableName("game_play")
public class GamePlayEntity extends BaseEntity {
    @TableId(type = IdType.AUTO,value = "id")
    private Long id;
    private String name;
    private String code;
    private Integer status;
    @TableField("game_id")
    private Long gameId;
    @TableField("game_play_type_id")
    private Long gamePlayTypeId;
}
