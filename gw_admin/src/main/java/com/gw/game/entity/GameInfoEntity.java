package com.gw.game.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gw.base.entity.BaseEntity;
import com.gw.game.req.gameInfo.AddGameInfoReq;
import lombok.Data;

import java.util.Date;

/**
 * @author zzby
 * @version 创建时间： 2024/7/22 11:16
 */
@Data
@TableName("game_info")
public class GameInfoEntity extends BaseEntity {
    @TableId(type = IdType.AUTO,value = "id")
    private Long id;
    private String name;
    private String code;
    private Integer status;
    private String icon;
    private Integer order;
    private Integer type;


    public GameInfoEntity(){}
    public GameInfoEntity(AddGameInfoReq req){
        this.name=req.getName();
        this.code=req.getCode();
        this.status=req.getStatus();
        this.icon=req.getIcon();
        this.order=req.getOrder();
        this.type=req.getType();

        this.setCreatedAt(new Date());
        this.setUpdatedAt(new Date());
    }

}
