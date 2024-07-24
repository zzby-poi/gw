package com.gw.plantform.req.plantformGame;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author zzby
 * @version 创建时间： 2024/7/23 11:40
 */
@Data
public class DeletePlantformGameReq {
    @NotBlank(message = "平台Id不能为空")
    @ApiModelProperty(value = "平台Id",required = true)
    private Long plantformId;

    @NotBlank(message = "游戏id不能为空")
    @ApiModelProperty(value = "游戏id",required = true)
    private Long gameId;
}
