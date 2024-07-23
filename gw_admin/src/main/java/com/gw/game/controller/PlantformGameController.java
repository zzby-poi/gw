package com.gw.game.controller;

import com.gw.base.resp.ApiResp;
import com.gw.game.req.plantformGame.PagePlantformGameListReq;
import com.gw.game.service.PlantformGameService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzby
 * @version 创建时间： 2024/7/22 18:46
 */
@RestController
@RequestMapping("/plantform_game")
public class PlantformGameController {
    @Autowired
    PlantformGameService plantformGameService;

    @PostMapping("/page_list")
    @ApiOperation(value = "分页平台游戏列表")
    public ApiResp<String> getPagePlantformGameList(PagePlantformGameListReq req){
        return plantformGameService.getPagePlantformGameList(req);
    }

}
