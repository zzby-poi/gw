package com.gw.game.req.gamePlayType;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author zzby
 * @version 创建时间： 2024/7/22 18:16
 */
@Data
public class EnableGamePlayTypeListByGameIdReq {
    @NotBlank(message = "游戏ID不能为空")
    @ApiModelProperty(value = "游戏ID",required = true)
    private Long gameId;
}
