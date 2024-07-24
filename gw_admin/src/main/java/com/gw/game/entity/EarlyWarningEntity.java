package com.gw.game.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gw.base.entity.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * 报警预警信息表
 * @TableName early_warning
 */
@TableName(value ="early_warning")
@Data
public class EarlyWarningEntity extends BaseEntity {
    /**
     * 
     */
    @TableId
    private Long id;

    /**
     * 商户ID
     */
    private Long merchantId;

    /**
     * 预警类型
     */
    private Integer warnType;

    /**
     * 平台id
     */
    private Long planformId;

    /**
     * 报警预警内容
     */
    private String content;

    /**
     * 状态（0 待处理，1处理中，2已处理）
     */
    private Integer status;

    /**
     * 游戏ID
     */
    private Long gameId;

    /**
     * 处理人
     */
    private String handler;

    /**
     * 处理时间
     */
    private Date handleTime;

    /**
     * 处理完成时间
     */
    private Date handleEndTime;
}