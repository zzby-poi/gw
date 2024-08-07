package com.gw.plantform.service;

import com.gw.base.resp.ApiResp;
import com.gw.plantform.entity.PlantformMerchantGamePlayEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gw.plantform.req.merchantGamePlay.AddMerchantGamePlayReq;
import com.gw.plantform.req.merchantGamePlay.DeleteMerchantGamePlayReq;
import com.gw.plantform.req.merchantGamePlay.PageMerchantGamePlayListReq;
import com.gw.plantform.req.merchantGamePlay.StatusMerchantGamePlayReq;

/**
* @author zzby
* @description 针对表【plantform_merchant_game_play(商户游戏玩法关联表)】的数据库操作Service
* @createDate 2024-07-23 16:41:38
*/
public interface PlantformMerchantGamePlayService extends IService<PlantformMerchantGamePlayEntity> {

    ApiResp getPageMerchantGamePlayList(PageMerchantGamePlayListReq req);

    ApiResp addMerchantGamePlay(AddMerchantGamePlayReq req);

    ApiResp statusMerchantGamePlay(StatusMerchantGamePlayReq req);

    ApiResp deleteMerchantGamePlay(DeleteMerchantGamePlayReq req);
}
