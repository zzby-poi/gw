package com.gw.game.controller;

import com.gw.base.resp.ApiResp;
import com.gw.game.req.gameInfo.*;
import com.gw.game.service.GameInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzby
 * @version 创建时间： 2024/7/22 11:15
 */
@RestController
@RequestMapping("/game_info")
public class GameInfoController {
    @Autowired
    GameInfoService gameInfoService;

    @PostMapping("/page_list")
    @ApiOperation(value = "分页获取游戏信息列表")
    public ApiResp<String> getPageGameInfoList(PageGameInfoListReq req){
        return gameInfoService.getPageGameInfoList(req);
    }

    @PostMapping("/add")
    @ApiOperation(value = "新增游戏信息")
    public ApiResp<String> addGameInfo(AddGameInfoReq req){
        return gameInfoService.addGameInfo(req);
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改游戏信息")
    public ApiResp<String> updateGameInfo(UpdateGameInfoReq req){
        return gameInfoService.updateGameInfo(req);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除游戏信息")
    public ApiResp<String> deleteGameInfo(DeleteGameInfoReq req){
        return gameInfoService.deleteGameInfo(req);
    }

    @PostMapping("/status")
    @ApiOperation(value = "启/停用游戏信息")
    public ApiResp<String> statusGameInfo(StatusGameInfoReq req){
        return gameInfoService.statusGameInfo(req);
    }

    @PostMapping("/list")
    @ApiOperation(value = "分页获取游戏信息列表")
    public ApiResp<String> getGameInfoList(GetGameInfoListReq req){
        return gameInfoService.getGameInfoList(req);
    }

//    @PostMapping("/list")
//    @ApiOperation(value = "游戏分配游戏玩法类型")
//    public ApiResp<String> getGameInfoList(GetGameInfoListReq req){
//        return gameInfoService.getGameInfoList(req);
//    }

}
