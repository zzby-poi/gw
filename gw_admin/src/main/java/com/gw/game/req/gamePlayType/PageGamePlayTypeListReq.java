package com.gw.game.req.gamePlayType;

import com.gw.base.req.BasePageReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zzby
 * @version 创建时间： 2024/7/22 16:38
 */
@Data
public class PageGamePlayTypeListReq extends BasePageReq {
    @ApiModelProperty(value = "游戏玩法类型名称")
    private String name;

    @ApiModelProperty(value = "游戏玩法类型编码")
    private String code;

    @ApiModelProperty(value = "状态")
    private Integer status;
}
