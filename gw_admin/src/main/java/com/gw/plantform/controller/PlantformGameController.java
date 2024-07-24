package com.gw.plantform.controller;

import com.gw.base.resp.ApiResp;
import com.gw.plantform.req.plantformGame.AddPlantformGameReq;
import com.gw.plantform.req.plantformGame.DeletePlantformGameReq;
import com.gw.plantform.req.plantformGame.PagePlantformGameListReq;
import com.gw.plantform.req.plantformGame.StatusPlantformGameReq;
import com.gw.plantform.service.PlantformGameService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzby
 * @version 创建时间： 2024/7/23 11:37
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

    @PostMapping("/add")
    @ApiOperation(value = "新增平台游戏玩法")
    public ApiResp<String> addPlantformGame(AddPlantformGameReq req){
        return plantformGameService.addPlantformGame(req);
    }

    @PostMapping("/status")
    @ApiOperation(value = "启/停用平台游戏玩法")
    public ApiResp<String> statusPlantformGame(StatusPlantformGameReq req){
        return plantformGameService.statusPlantformGame(req);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除平台游戏玩法")
    public ApiResp<String> deletePlantformGame(DeletePlantformGameReq req){
        return plantformGameService.deletePlantformGame(req);
    }


}
