package com.gw.game.req.gameInfo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author zzby
 * @version 创建时间： 2024/7/22 14:13
 */
@Data
public class UpdateGameInfoReq {
    @NotBlank(message = "游戏id不能为空")
    @ApiModelProperty(value = "游戏id",required = true)
    private Long id;

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
}
