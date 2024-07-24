package com.gw.plantform.req.plantformGame;

import com.gw.base.req.BasePageReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zzby
 * @version 创建时间： 2024/7/23 9:56
 */
@Data
public class PagePlantformGameListReq extends BasePageReq {
    @ApiModelProperty(value = "平台Id")
    private Long plantformId;
    @ApiModelProperty(value = "游戏类型")
    private Integer type;
    @ApiModelProperty(value = "状态")
    private Integer status;
}
