package com.gw.plantform.service;

import com.gw.base.resp.ApiResp;
import com.gw.plantform.entity.PlantformMerchantGameEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gw.plantform.req.merchantGame.*;

/**
* @author zzby
* @description 针对表【plantform_merchant_game(商户游戏关联表)】的数据库操作Service
* @createDate 2024-07-23 17:42:55
*/
public interface PlantformMerchantGameService extends IService<PlantformMerchantGameEntity> {
    ApiResp getPageMerchantGameList(PageMerchantGameListReq req);

    ApiResp addMerchantGame(AddMerchantGameReq req);

    ApiResp statusMerchantGame(StatusMerchantGameReq req);

    ApiResp deleteMerchantGame(DeleteMerchantGameReq req);

    ApiResp updateMerchantGame(UpdateMerchantGameReq req);
}
