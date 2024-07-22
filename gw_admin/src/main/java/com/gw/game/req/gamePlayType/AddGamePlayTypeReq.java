package com.gw.game.req.gamePlayType;

import com.gw.base.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author zzby
 * @version 创建时间： 2024/7/22 17:54
 */
@Data
public class AddGamePlayTypeReq extends BaseEntity {
    @NotBlank(message = "游戏玩法类型名称不能为空")
    @ApiModelProperty(value = "游戏玩法类型名称",required = true)
    private String name;

    @NotBlank(message = "游戏玩法类型编码不能为空")
    @ApiModelProperty(value = "游戏玩法类型编码",required = true)
    private String code;

    @NotBlank(message = "状态不能为空")
    @ApiModelProperty(value = "状态",required = true)
    private Integer status;
}
