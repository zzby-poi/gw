package com.gw.game.mapper;

import com.gw.game.entity.GamePlayEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gw.game.resp.gamePlay.GetGamePlayListResp;
import com.gw.game.resp.gamePlay.PageGamePlayListResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author zzby
* @description 针对表【game_play(游戏玩法)】的数据库操作Mapper
* @createDate 2024-07-22 15:15:56
*/
@Mapper
public interface GamePlayMapper extends BaseMapper<GamePlayEntity> {

    List<PageGamePlayListResp> getPageGamePlayList(@Param("gamePlayName") String gamePlayName,
                                                   @Param("status") Integer status,
                                                   @Param("gameId") Long gameId);

    List<GetGamePlayListResp> getGamePlayList(@Param("gameId") Long gameId,
                                              @Param("plantformId") Long plantformId);

}




