package com.gw.game.req.gamePlay;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author zzby
 * @version 创建时间： 2024/7/22 16:01
 */
@Data
public class DeleteGamePlayReq {
    @NotBlank(message = "主键不能为空")
    @ApiModelProperty(value = "主键",required = true)
    private Long id;
}
