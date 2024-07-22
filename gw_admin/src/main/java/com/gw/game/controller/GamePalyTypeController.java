package com.gw.game.controller;

import com.gw.base.resp.ApiResp;
import com.gw.game.req.gamePlay.PageGamePlayListReq;
import com.gw.game.service.GamePalyTypeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
    @ApiOperation(value = "分页游戏玩法列表")
    public ApiResp<String> getPageGamePalyList(PageGamePlayListReq req){
        return gamePalyTypeService.getPageGamePalyList(req);
    }
}
