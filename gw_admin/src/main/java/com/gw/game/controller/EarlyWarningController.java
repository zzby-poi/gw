package com.gw.game.controller;

import com.gw.base.resp.ApiResp;
import com.gw.game.service.EarlyWarningService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzby
 * @version 创建时间： 2024/7/24 9:38
 */
@RestController
@RequestMapping("/warning")
public class EarlyWarningController {
    @Autowired
    EarlyWarningService earlyWarningService;

    @PostMapping("/default_add")
    @ApiOperation(value = "默认添加预警报警信息")
    public ApiResp<String> defaultAdd() {
        return earlyWarningService.defaultAdd();
    }
}
