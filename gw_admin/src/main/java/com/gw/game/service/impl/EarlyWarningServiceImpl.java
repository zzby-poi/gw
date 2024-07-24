package com.gw.game.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gw.base.resp.ApiResp;
import com.gw.game.entity.EarlyWarningEntity;
import com.gw.game.service.EarlyWarningService;
import com.gw.game.mapper.EarlyWarningMapper;
import org.springframework.stereotype.Service;

/**
* @author zzby
* @description 针对表【early_warning(报警预警信息表)】的数据库操作Service实现
* @createDate 2024-07-24 09:37:46
*/
@Service
public class EarlyWarningServiceImpl extends ServiceImpl<EarlyWarningMapper, EarlyWarningEntity>
    implements EarlyWarningService{

    /**
     * 添加默认预警报警信息
     * 预警类消息状态默认为待处理
     * @return
     */
    @Override
    public ApiResp<String> defaultAdd() {
        EarlyWarningEntity warning = new EarlyWarningEntity();
        warning.setStatus(0);
        baseMapper.insert(warning);
        return ApiResp.sucess();
    }


}




