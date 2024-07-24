package com.gw.plantform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gw.base.resp.ApiResp;
import com.gw.plantform.entity.PlantformGamePlayEntity;
import com.gw.plantform.req.plantformGamePlay.AddPlantformGamePlayReq;
import com.gw.plantform.req.plantformGamePlay.DeletePlantformGamePlayReq;
import com.gw.plantform.req.plantformGamePlay.PagePlantformGamePlayListReq;
import com.gw.plantform.req.plantformGamePlay.StatusPlantformGamePlayReq;

/**
* @author zzby
* @description 针对表【plantform_game(平台游戏关联表)】的数据库操作Service
* @createDate 2024-07-23 09:43:35
*/
public interface PlantformGamePlayService extends IService<PlantformGamePlayEntity> {

    ApiResp<String> getPagePlantformGamePlayList(PagePlantformGamePlayListReq req);

    ApiResp<String> addPlantformGamePlay(AddPlantformGamePlayReq req);

    ApiResp<String> statusPlantformGamePlay(StatusPlantformGamePlayReq req);

    ApiResp<String> deletePlantformGamePlay(DeletePlantformGamePlayReq req);
}
