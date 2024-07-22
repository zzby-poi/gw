package com.gw.game.req.gameInfo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author zzby
 * @version 创建时间： 2024/7/22 14:25
 */
@Data
public class StatusGameInfoReq {
    @NotBlank(message = "游戏id不能为空")
    @ApiModelProperty(value = "游戏id",required = true)
    private Long id;

    @NotBlank(message = "状态不能为空")
    @ApiModelProperty(value = "状态",required = true)
    private Integer status;
}
