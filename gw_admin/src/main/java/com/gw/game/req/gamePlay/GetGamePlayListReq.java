package com.gw.game.req.gamePlay;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author zzby
 * @version 创建时间： 2024/7/22 16:08
 */
@Data
public class GetGamePlayListReq {
    @NotBlank(message = "游戏Id不能为空")
    @ApiModelProperty(value = "游戏Id",required = true)
    private Long gameId;

    @ApiModelProperty(value = "平台id")
    private Long plantformId;
}
