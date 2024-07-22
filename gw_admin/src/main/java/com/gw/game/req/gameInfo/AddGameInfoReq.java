package com.gw.game.req.gameInfo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author zzby
 * @version 创建时间： 2024/7/22 13:53
 */
@Data
public class AddGameInfoReq {
    @NotBlank(message = "游戏名称不能为空")
    @ApiModelProperty(value = "游戏名称",required = true)
    private String name;

    @NotBlank(message = "状态不能为空")
    @ApiModelProperty(value = "状态",required = true)
    private Integer status;

    @NotBlank(message = "游戏图标不能为空")
    @ApiModelProperty(value = "游戏图标",required = true)
    private String icon;

    @NotBlank(message = "游戏排序号不能为空")
    @ApiModelProperty(value = "游戏排序号",required = true)
    private Integer order;

    @NotBlank(message = "游戏类型不能为空")
    @ApiModelProperty(value = "游戏类型",required = true)
    private Integer type;

    @NotBlank(message = "游戏code不能为空")
    @ApiModelProperty(value = "游戏code",required = true)
    private String code;
}
