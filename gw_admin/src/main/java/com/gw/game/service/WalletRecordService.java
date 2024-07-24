package com.gw.game.service;

import com.gw.game.entity.WalletRecordEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author zzby
* @description 针对表【wallet_record(钱包余额变动记录)】的数据库操作Service
* @createDate 2024-07-24 09:53:51
*/
public interface WalletRecordService extends IService<WalletRecordEntity> {

    void change();
}
