package com.gw.game.req.merchantGame;

import com.gw.game.entity.GamePlayInfos;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author zzby
 * @version 创建时间： 2024/7/23 17:06
 */
@Data
public class AddMerchantGameReq {
    @NotBlank(message = "商户id不能为空")
    @ApiModelProperty(value = "商户id")
    private Long merchantId;

    @NotBlank(message = "游戏id不能为空")
    @ApiModelProperty(value = "游戏id")
    private Long gameId;

    @NotBlank(message = "状态不能为空")
    @ApiModelProperty(value = "状态(商户游戏关联表)")
    private Integer status;
}
