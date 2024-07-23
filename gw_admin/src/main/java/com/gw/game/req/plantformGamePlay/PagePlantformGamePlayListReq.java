package com.gw.game.req.plantformGamePlay;

import com.gw.base.req.BasePageReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author zzby
 * @version 创建时间： 2024/7/23 9:56
 */
@Data
public class PagePlantformGamePlayListReq extends BasePageReq {
    @NotBlank(message = "平台Id不能为空")
    @ApiModelProperty(value = "平台Id", required = true)
    private Long plantformId;

    @NotBlank(message = "游戏id不能为空")
    @ApiModelProperty(value = "游戏Id", required = true)
    private Long gameId;

    @ApiModelProperty(value = "状态")
    private Integer status;
}
