package com.gw.game.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.gw.base.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 钱包余额变动记录
 * @TableName wallet_record
 */
@TableName(value ="wallet_record")
@Data
public class WalletRecordEntity extends BaseEntity {
    /**
     * 
     */
    @TableId
    private Long id;

    /**
     * 钱包ID
     */
    private Long walletId;

    /**
     * 变动金额
     */
    private Double changeAmt;

    /**
     * 变动前余额
     */
    private Double beforeBlanace;

    /**
     * 变动后余额
     */
    private Double afterBlanace;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 描述
     */
    private String remark;

}