package com.gw.game.req.gamePlay;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author zzby
 * @version 创建时间： 2024/7/22 15:58
 */
@Data
public class UpdateGamePlayReq {
    @NotBlank(message = "主键不能为空")
    @ApiModelProperty(value = "主键",required = true)
    private Long id;

    @NotBlank(message = "玩法名称不能为空")
    @ApiModelProperty(value = "玩法名称",required = true)
    private String name;

    @NotBlank(message = "状态不能为空")
    @ApiModelProperty(value = "状态",required = true)
    private Integer status;

    @NotBlank(message = "游戏Id不能为空")
    @ApiModelProperty(value = "游戏Id",required = true)
    private Long gameId;

    @NotBlank(message = "游戏玩法类型Id不能为空")
    @ApiModelProperty(value = "游戏玩法类型Id",required = true)
    private Long gamePlayTypeId;
}
