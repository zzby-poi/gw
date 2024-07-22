package com.gw.game.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gw.base.resp.ApiResp;
import com.gw.game.entity.GameInfoEntity;
import com.gw.game.req.gameInfo.*;

/**
 * @author zzby
 * @version 创建时间： 2024/7/22 11:15
 */
public interface GameInfoService extends IService<GameInfoEntity> {
    ApiResp getPageGameInfoList(PageGameInfoListReq req);

    ApiResp<String> addGameInfo(AddGameInfoReq req);

    ApiResp<String> updateGameInfo(UpdateGameInfoReq req);

    ApiResp<String> deleteGameInfo(DeleteGameInfoReq req);

    ApiResp<String> statusGameInfo(StatusGameInfoReq req);

    ApiResp<String> getGameInfoList(GetGameInfoListReq req);
}
