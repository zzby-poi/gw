package com.gw.log.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gw.admin.entity.AdminNoteEntity;
import com.gw.log.entity.SysDataLogEntity;
import com.gw.log.service.SysDataLogService;
import com.gw.log.mapper.SysDataLogMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author zzby
* @description 针对表【sys_data_log(系统数据操作日志表)】的数据库操作Service实现
* @createDate 2024-07-24 10:45:13
*/
@Service
public class SysDataLogServiceImpl extends ServiceImpl<SysDataLogMapper, SysDataLogEntity>
    implements SysDataLogService{

    /**
     * 每日4点
     * 删除3个月之前的数据
     */
    @Scheduled(cron = "0 0 4 * * ?")
    public void clearProcessedWarnings(){
        Date olderMonthAgo = new Date(System.currentTimeMillis() - 90L*24*60*60*1000);
        QueryWrapper<SysDataLogEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lt("created_at", olderMonthAgo);
        List<SysDataLogEntity> list = baseMapper.selectList(queryWrapper);
        baseMapper.deleteBatchIds(list);
    }
}




