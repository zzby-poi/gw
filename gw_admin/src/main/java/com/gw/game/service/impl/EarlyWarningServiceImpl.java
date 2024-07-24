package com.gw.game.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gw.base.resp.ApiResp;
import com.gw.game.entity.EarlyWarningEntity;
import com.gw.game.service.EarlyWarningService;
import com.gw.game.mapper.EarlyWarningMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Queue;

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

    /**
     * 每日凌晨1点定时清除一个月以上状态为已处理的报警预警信息
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void clearProcessedWarnings(){
        Date olderMonthAgo = new Date(System.currentTimeMillis() - 30L*24*60*60*1000);
        QueryWrapper<EarlyWarningEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", 1);
        queryWrapper.lt("updated_at", olderMonthAgo);
        List<EarlyWarningEntity> list = baseMapper.selectList(queryWrapper);
        baseMapper.deleteBatchIds(list);
    }

}




