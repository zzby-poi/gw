package com.gw.game.req.gameInfo;

import com.gw.base.req.BasePageReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * @author zzby
 * @version 创建时间： 2024/7/22 11:26
 */
@Data
public class PageGameInfoListReq extends BasePageReq {
    @ApiModelProperty(value = "游戏名称")
    private String gameName;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "游戏类型")
    private Integer type;
}
