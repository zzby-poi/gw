package com.gw.game.req.gamePlayType;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zzby
 * @version 创建时间： 2024/7/22 16:38
 */
@Data
public class PageGamePlayTypeListReq {
    @ApiModelProperty(value = "游戏玩法类型名称")
    private String name;

    @ApiModelProperty(value = "游戏玩法类型编码")
    private Integer code;

    @ApiModelProperty(value = "转态")
    private Integer status;
}
