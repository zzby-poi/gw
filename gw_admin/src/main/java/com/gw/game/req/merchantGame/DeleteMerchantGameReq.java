package com.gw.game.req.merchantGame;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author zzby
 * @version 创建时间： 2024/7/23 17:39
 */
@Data
public class DeleteMerchantGameReq {
    @NotBlank(message = "商户ID不能为空")
    @ApiModelProperty(value = "商户ID",required = true)
    private Long merchantId;
}
