package com.gw.game.service;

import com.gw.base.resp.ApiResp;
import com.gw.game.entity.GamePlayEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gw.game.req.gamePlay.*;

/**
* @author zzby
* @description 针对表【game_play(游戏玩法)】的数据库操作Service
* @createDate 2024-07-22 15:15:56
*/
public interface GamePlayService extends IService<GamePlayEntity> {

    ApiResp<String> getPageGamePlayList(PageGamePlayListReq req);

    ApiResp<String> addGamePlay(AddGamePlayReq req);

    ApiResp<String> updateGamePlay(UpdateGamePlayReq req);

    ApiResp<String> deleteGamePlay(DeleteGamePlayReq req);

    ApiResp<String> statusGamePlay(StatusGamePlayReq req);

    ApiResp<String> getGamePlayList(GetGamePlayListReq req);
}
