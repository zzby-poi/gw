package com.gw.game.controller;

import com.gw.base.resp.ApiResp;
import com.gw.game.req.gamePlay.*;
import com.gw.game.service.GamePlayService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzby
 * @version 创建时间： 2024/7/22 15:04
 */
@RestController
@RequestMapping("/game_play")
public class GamePlayController {
    @Autowired
    GamePlayService gamePlayService;

    @PostMapping("/page_list")
    @ApiOperation(value = "分页游戏玩法列表")
    public ApiResp<String> getPageGamePlayList(PageGamePlayListReq req){
        return gamePlayService.getPageGamePlayList(req);
    }

    @PostMapping("/add")
    @ApiOperation(value = "新增游戏玩法")
    public ApiResp<String> addGamePlay(AddGamePlayReq req){
        return gamePlayService.addGamePlay(req);
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改游戏玩法")
    public ApiResp<String> updateGamePlay(UpdateGamePlayReq req){
        return gamePlayService.updateGamePlay(req);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "修改游戏玩法")
    public ApiResp<String> deleteGamePlay(DeleteGamePlayReq req){
        return gamePlayService.deleteGamePlay(req);
    }

    @PostMapping("/status")
    @ApiOperation(value = "启/停用游戏玩法")
    public ApiResp<String> statusGamePlay(StatusGamePlayReq req){
        return gamePlayService.statusGamePlay(req);
    }

    @PostMapping("/list")
    @ApiOperation(value = "游戏玩法列表")
    public ApiResp<String> getGamePlayList(GetGamePlayListReq req){
        return gamePlayService.getGamePlayList(req);
    }

}
