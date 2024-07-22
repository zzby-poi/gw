package com.gw.game.req.gamePlay;

import com.gw.base.req.BasePageReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zzby
 * @version 创建时间： 2024/7/22 15:25
 */
@Data
public class PageGamePlayListReq extends BasePageReq {
    @ApiModelProperty(value = "游戏玩法名称")
    private String gamePlayName;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "游戏id")
    private Long gameId;
}
