package com.gw.game.controller;

import com.gw.game.service.PlantformInfoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    PlantformInfoService plantformInfoService;


}
