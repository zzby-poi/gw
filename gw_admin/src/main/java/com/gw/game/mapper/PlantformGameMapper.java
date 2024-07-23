package com.gw.game.mapper;

import com.gw.game.entity.PlantformGameEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gw.game.resp.plantformGame.PagePlantformGameListResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author zzby
* @description 针对表【plantform_game(平台游戏关联表)】的数据库操作Mapper
* @createDate 2024-07-23 11:48:02
* @Entity com.gw.game.entity.PlantformGame
*/
public interface PlantformGameMapper extends BaseMapper<PlantformGameEntity> {
    List<PagePlantformGameListResp> getPagePlantformGameList(@Param("plantformId") Long plantformId,
                                                             @Param("type") Integer type,
                                                             @Param("status") Integer status);
}




