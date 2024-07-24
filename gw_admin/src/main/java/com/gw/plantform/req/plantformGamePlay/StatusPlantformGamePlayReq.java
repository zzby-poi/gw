package com.gw.plantform.req.plantformGamePlay;

import com.gw.game.entity.GamePlayEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author zzby
 * @version 创建时间： 2024/7/23 11:17
 */
@Data
public class StatusPlantformGamePlayReq {
    @NotBlank(message = "平台Id不能为空")
    @ApiModelProperty(value = "平台Id",required = true)
    private Long plantformId;

    @NotBlank(message = "游戏玩法id不能为空")
    @ApiModelProperty(value = "游戏玩法id",required = true)
    private Long gamePlayId;

    @NotBlank(message = "状态不能为空")
    @ApiModelProperty(value = "状态",required = true)
    private Integer status;
}
