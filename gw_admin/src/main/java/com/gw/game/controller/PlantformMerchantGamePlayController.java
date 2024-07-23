package com.gw.game.controller;

import com.gw.game.service.PlantformMerchantGamePlayService;
import org.springframework.beans.factory.annotation.Autowired;
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


}
