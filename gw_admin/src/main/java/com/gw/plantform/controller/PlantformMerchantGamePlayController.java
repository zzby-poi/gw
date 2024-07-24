package com.gw.plantform.controller;

import com.gw.base.resp.ApiResp;
import com.gw.plantform.req.merchantGamePlay.AddMerchantGamePlayReq;
import com.gw.plantform.req.merchantGamePlay.DeleteMerchantGamePlayReq;
import com.gw.plantform.req.merchantGamePlay.PageMerchantGamePlayListReq;
import com.gw.plantform.req.merchantGamePlay.StatusMerchantGamePlayReq;
import com.gw.plantform.service.PlantformMerchantGamePlayService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzby
 * @version 创建时间： 2024/7/23 16:42
 */
@RestController
@RequestMapping("/merchant_game_play")
public class PlantformMerchantGamePlayController {
    @Autowired
    PlantformMerchantGamePlayService service;

    @PostMapping("/page_list")
    @ApiOperation(value = "分页商户游戏玩法")
    public ApiResp getPageMerchantGamePlayList(PageMerchantGamePlayListReq req) {
        return service.getPageMerchantGamePlayList(req);
    }

    @PostMapping("/add")
    @ApiOperation(value = "新增商户游戏玩法")
    public ApiResp addMerchantGamePlay(AddMerchantGamePlayReq req) {
        return service.addMerchantGamePlay(req);
    }

    @PostMapping("/status")
    @ApiOperation(value = "启/停用商户游戏玩法")
    public ApiResp statusMerchantGamePlay(StatusMerchantGamePlayReq req) {
        return service.statusMerchantGamePlay(req);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除商户游戏玩法")
    public ApiResp deleteMerchantGamePlay(DeleteMerchantGamePlayReq req) {
        return service.deleteMerchantGamePlay(req);
    }

}
