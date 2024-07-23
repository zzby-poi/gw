package com.gw.game.req.plantformGame;

import com.gw.base.entity.BaseEntity;
import com.gw.game.entity.GameInfoEntity;
import com.gw.game.entity.GameInfos;
import com.gw.game.entity.GamePlayEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author zzby
 * @version 创建时间： 2024/7/23 10:26
 */
@Data
public class AddPlantformGameReq extends BaseEntity {
    @NotBlank(message = "平台Id不能为空")
    @ApiModelProperty(value = "平台Id",required = true)
    private Long plantformId;

    @NotBlank(message = "游戏信息集合不能为空")
    @ApiModelProperty(value = "游戏信息集合",required = true)
    private List<GameInfos> gameInfos;
}
