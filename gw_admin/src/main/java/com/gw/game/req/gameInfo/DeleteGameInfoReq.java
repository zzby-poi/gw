package com.gw.game.req.gameInfo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author zzby
 * @version 创建时间： 2024/7/22 14:21
 */
@Data
public class DeleteGameInfoReq {
    @NotNull(message = "游戏id不能为空")
    @ApiModelProperty(value = "游戏id",required = true)
    private Long id;
}
