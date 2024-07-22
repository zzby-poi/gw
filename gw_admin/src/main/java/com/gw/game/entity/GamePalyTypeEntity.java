package com.gw.game.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 游戏玩法配置
 * @TableName game_paly_type
 */
@Data
@TableName(value ="game_paly_type")
public class GamePalyTypeEntity implements Serializable {
    /**
     * 
     */
    @TableId
    private Long id;

    /**
     * 游戏玩法类型编码
     */
    private String code;

    /**
     * 游戏玩法名称
     */
    private String name;

    /**
     * 状态（0停用，1启用）
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


}