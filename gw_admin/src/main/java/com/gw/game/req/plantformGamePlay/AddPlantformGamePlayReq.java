package com.gw.game.req.plantformGamePlay;

import com.gw.base.entity.BaseEntity;
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
public class AddPlantformGamePlayReq extends BaseEntity {
    @NotBlank(message = "平台Id不能为空")
    @ApiModelProperty(value = "平台Id",required = true)
    private Long plantformId;

    @NotBlank(message = "游戏玩法信息集合不能为空")
    @ApiModelProperty(value = "游戏玩法信息集合",required = true)
    private List<GamePlayEntity> gamePlayInfos;
}
