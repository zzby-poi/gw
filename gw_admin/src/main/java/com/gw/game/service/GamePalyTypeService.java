package com.gw.game.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gw.base.resp.ApiResp;
import com.gw.game.entity.GamePalyTypeEntity;
import com.gw.game.req.gamePlayType.*;

/**
* @author zzby
* @description 针对表【game_paly_type(游戏玩法配置)】的数据库操作Service
* @createDate 2024-07-22 16:29:07
*/
public interface GamePalyTypeService extends IService<GamePalyTypeEntity> {

    ApiResp<String> getPageGamePlayTypeList(PageGamePlayTypeListReq req);

    ApiResp<String> addGamePlayType(AddGamePlayTypeReq req);

    ApiResp<String> updateGamePlayType(UpdateGamePlayTypeReq req);

    ApiResp<String> deleteGamePlayType(DeleteGamePlayTypeReq req);

    ApiResp<String> statusGamePlayType(StatusGamePlayTypeReq req);

    ApiResp<String> enableGamePlayTypeList();

    ApiResp<String> enableGamePlayTypeListByGameId(EnableGamePlayTypeListByGameIdReq req);
}
