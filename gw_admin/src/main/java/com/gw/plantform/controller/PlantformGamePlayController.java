package com.gw.plantform.controller;

import com.gw.base.resp.ApiResp;
import com.gw.plantform.req.plantformGamePlay.AddPlantformGamePlayReq;
import com.gw.plantform.req.plantformGamePlay.DeletePlantformGamePlayReq;
import com.gw.plantform.req.plantformGamePlay.PagePlantformGamePlayListReq;
import com.gw.plantform.req.plantformGamePlay.StatusPlantformGamePlayReq;
import com.gw.plantform.service.PlantformGamePlayService;
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
@RequestMapping("/plantform_game_play")
public class PlantformGamePlayController {
    @Autowired
    PlantformGamePlayService plantformGamePlayService;

    @PostMapping("/page_list")
    @ApiOperation(value = "分页平台游戏列表")
    public ApiResp<String> getPagePlantformGamePlayList(PagePlantformGamePlayListReq req){
        return plantformGamePlayService.getPagePlantformGamePlayList(req);
    }

    @PostMapping("/add")
    @ApiOperation(value = "新增平台游戏玩法")
    public ApiResp<String> addPlantformGamePlay(AddPlantformGamePlayReq req){
        return plantformGamePlayService.addPlantformGamePlay(req);
    }

    @PostMapping("/status")
    @ApiOperation(value = "启/停用平台游戏玩法")
    public ApiResp<String> statusPlantformGamePlay(StatusPlantformGamePlayReq req){
        return plantformGamePlayService.statusPlantformGamePlay(req);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除平台游戏玩法")
    public ApiResp<String> deletePlantformGamePlay(DeletePlantformGamePlayReq req){
        return plantformGamePlayService.deletePlantformGamePlay(req);
    }
}
