package com.gw.game.controller;

import com.gw.base.resp.ApiResp;
import com.gw.game.req.gamePlay.PageGamePlayListReq;
import com.gw.game.req.gamePlayType.*;
import com.gw.game.service.GamePalyTypeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzby
 * @version 创建时间： 2024/7/22 16:24
 */
@RestController
@RequestMapping("/game_play_type")
public class GamePalyTypeController {
    @Autowired
    GamePalyTypeService gamePalyTypeService;

    @PostMapping("/page_list")
    @ApiOperation(value = "分页游戏玩法类型列表")
    public ApiResp<String> getPageGamePlayTypeList(PageGamePlayTypeListReq req){
        return gamePalyTypeService.getPageGamePlayTypeList(req);
    }

    @PostMapping("/add")
    @ApiOperation(value = "新增游戏玩法类型")
    public ApiResp<String> addGamePlayType(AddGamePlayTypeReq req){
        return gamePalyTypeService.addGamePlayType(req);
    }

    @PostMapping("/update")
    @ApiOperation(value = "新增游戏玩法类型")
    public ApiResp<String> updateGamePlayType(UpdateGamePlayTypeReq req){
        return gamePalyTypeService.updateGamePlayType(req);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "新增游戏玩法类型")
    public ApiResp<String> deleteGamePlayType(DeleteGamePlayTypeReq req){
        return gamePalyTypeService.deleteGamePlayType(req);
    }

    @PostMapping("/status")
    @ApiOperation(value = "启/停用游戏玩法类型")
    public ApiResp<String> statusGamePlayType(StatusGamePlayTypeReq req){
        return gamePalyTypeService.statusGamePlayType(req);
    }

    @GetMapping("/enable_list")
    @ApiOperation(value = "启用状态的游戏玩法类型列表")
    public ApiResp<String> enableGamePlayTypeList(){
        return gamePalyTypeService.enableGamePlayTypeList();
    }

    @PostMapping("/enable_list_by_game_id")
    @ApiOperation(value = "根据游戏ID查询启用状态的游戏玩法类型列表")
    public ApiResp<String> enableGamePlayTypeListByGameId(EnableGamePlayTypeListByGameIdReq req){
        return gamePalyTypeService.enableGamePlayTypeListByGameId(req);
    }

}
