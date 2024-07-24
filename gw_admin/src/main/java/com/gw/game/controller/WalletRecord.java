package com.gw.game.controller;

import com.gw.game.service.WalletRecordService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzby
 * @version 创建时间： 2024/7/24 9:55
 */
@RestController
@RequestMapping("/wallet_record")
public class WalletRecord {
    @Autowired
    WalletRecordService walletRecordService;

    @PostMapping("/change")
    @ApiOperation("钱包账变记录")
    public void change() {
        walletRecordService.change();
    }
}
