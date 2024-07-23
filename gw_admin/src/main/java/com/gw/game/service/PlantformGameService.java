package com.gw.game.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gw.base.resp.ApiResp;
import com.gw.game.entity.PlantformGameEntity;
import com.gw.game.req.plantformGame.PagePlantformGameListReq;

/**
* @author zzby
* @description 针对表【plantform_game(平台游戏关联表)】的数据库操作Service
* @createDate 2024-07-23 09:43:35
*/
public interface PlantformGameService extends IService<PlantformGameEntity> {

    ApiResp<String> getPagePlantformGameList(PagePlantformGameListReq req);
}
