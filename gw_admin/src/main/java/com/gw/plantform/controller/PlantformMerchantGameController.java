package com.gw.plantform.controller;

import com.gw.base.resp.ApiResp;
import com.gw.plantform.service.PlantformMerchantGameService;
import com.gw.plantform.req.merchantGame.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzby
 * @version 创建时间： 2024/7/23 17:43
 */
@RestController
@RequestMapping("/merchant_game")
public class PlantformMerchantGameController {
    @Autowired
    PlantformMerchantGameService service;

    @PostMapping("/page_list")
    @ApiOperation(value = "分页商户游戏列表")
    public ApiResp getPageMerchantGameList(PageMerchantGameListReq req) {
        return service.getPageMerchantGameList(req);
    }

    @PostMapping("/add")
    @ApiOperation(value = "新增商户游戏")
    public ApiResp addMerchantGame(AddMerchantGameReq req) {
        return service.addMerchantGame(req);
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改商户游戏")
    public ApiResp updateMerchantGame(UpdateMerchantGameReq req) {
        return service.updateMerchantGame(req);
    }

    @PostMapping("/status")
    @ApiOperation(value = "启/停用商户游戏玩法")
    public ApiResp statusMerchantGame(StatusMerchantGameReq req) {
        return service.statusMerchantGame(req);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除商户游戏玩法")
    public ApiResp deleteMerchantGame(DeleteMerchantGameReq req) {
        return service.deleteMerchantGame(req);
    }
}
