package com.gw.game.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gw.base.entity.BaseEntity;
import lombok.Data;

/**
 * @author zzby
 * @version 创建时间： 2024/7/22 15:13
 */
@Data
@TableName("game_info_playtype_mapping")
public class GameInfoPlaytypeMapping extends BaseEntity {
    @TableId(type = IdType.AUTO,value = "id")
    private Long id;
    @TableField("game_id")
    private Long gameId;
    @TableField("game_play_type")
    private Long gamePlayType;
}
