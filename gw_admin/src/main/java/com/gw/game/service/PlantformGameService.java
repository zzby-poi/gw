package com.gw.game.service;

import com.gw.base.resp.ApiResp;
import com.gw.game.entity.PlantformGameEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gw.game.req.plantformGame.AddPlantformGameReq;
import com.gw.game.req.plantformGame.DeletePlantformGameReq;
import com.gw.game.req.plantformGame.PagePlantformGameListReq;
import com.gw.game.req.plantformGame.StatusPlantformGameReq;

/**
* @author zzby
* @description 针对表【plantform_game(平台游戏关联表)】的数据库操作Service
* @createDate 2024-07-23 11:48:02
*/
public interface PlantformGameService extends IService<PlantformGameEntity> {
    ApiResp<String> getPagePlantformGameList(PagePlantformGameListReq req);

    ApiResp<String> addPlantformGame(AddPlantformGameReq req);

    ApiResp<String> statusPlantformGame(StatusPlantformGameReq req);

    ApiResp<String> deletePlantformGame(DeletePlantformGameReq req);
}
