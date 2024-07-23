package com.gw.game.req.merchantGamePlay;

import com.gw.game.entity.GamePlayInfos;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author zzby
 * @version 创建时间： 2024/7/23 17:06
 */
@Data
public class AddMerchantGamePlayReq {
    @NotBlank(message = "游戏id不能为空")
    @ApiModelProperty(value = "游戏id",required = true)
    private Long merchantId;

    @NotBlank(message = "游戏玩法信息集合不能为空")
    @ApiModelProperty(value = "游戏玩法信息集合",required = true)
    private GamePlayInfos gamePlayInfos;
}
