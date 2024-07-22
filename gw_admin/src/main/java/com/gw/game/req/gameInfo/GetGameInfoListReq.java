package com.gw.game.req.gameInfo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author zzby
 * @version 创建时间： 2024/7/22 14:37
 */
@Data
public class GetGameInfoListReq {
    @ApiModelProperty(value = "平台id")
    private Long plantformId;

    @ApiModelProperty(value = "游戏类型")
    private Integer type;
}
