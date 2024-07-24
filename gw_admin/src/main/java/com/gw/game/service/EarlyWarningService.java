package com.gw.game.service;

import com.gw.base.resp.ApiResp;
import com.gw.game.entity.EarlyWarningEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author zzby
* @description 针对表【early_warning(报警预警信息表)】的数据库操作Service
* @createDate 2024-07-24 09:37:46
*/
public interface EarlyWarningService extends IService<EarlyWarningEntity> {

    ApiResp<String> defaultAdd();
}
