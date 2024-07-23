package com.gw.game.req.merchantGamePlay;

import com.gw.base.req.BasePageReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zzby
 * @version 创建时间： 2024/7/23 16:45
 */
@Data
public class PageMerchantGamePlayListReq extends BasePageReq {
    @ApiModelProperty(value = "商户id")
    private Long merchantId;
    @ApiModelProperty(value = "游戏id")
    private Long gameId;
    @ApiModelProperty(value = "状态")
    private Integer status;
}
