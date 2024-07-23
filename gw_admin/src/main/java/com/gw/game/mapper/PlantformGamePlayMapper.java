package com.gw.game.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gw.game.entity.PlantformGamePlayEntity;
import com.gw.game.resp.plantformGamePlay.PagePlantformGamePlayListResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author zzby
* @description 针对表【plantform_game_play(平台游戏玩法表)】的数据库操作Mapper
* @createDate 2024-07-23 09:43:35
*/
@Mapper
public interface PlantformGamePlayMapper extends BaseMapper<PlantformGamePlayEntity> {
    List<PagePlantformGamePlayListResp> getPagePlantformGamePlayList(@Param("plantformId") Long plantformId,
                                                                 @Param("gameId") Long gameId,
                                                                 @Param("status") Integer status);

    void statusPlantformGamePlay(@Param("plantformId") Long plantformId,
                                 @Param("gamePlayId") Long gamePlayId,
                                 @Param("status") Integer status);
}




