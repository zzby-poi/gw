package com.gw.game.resp.plantformGame;

import com.gw.base.entity.BaseEntity;
import lombok.Data;

/**
 * @author zzby
 * @version 创建时间： 2024/7/23 10:02
 */
@Data
public class PagePlantformGameListResp{
    private Long id;
    private String name;
    private Integer status;
    private String icon;
    private Integer order;
    private Integer type;
    private String plantformName;
}
