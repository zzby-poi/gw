package com.gw.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gw.admin.entity.AdminNoteEntity;
import com.gw.admin.service.AdminNoteService;
import com.gw.admin.mapper.AdminNoteMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author zzby
* @description 针对表【admin_note(公告信息表)】的数据库操作Service实现
* @createDate 2024-07-24 10:41:26
*/
@Service
public class AdminNoteServiceImpl extends ServiceImpl<AdminNoteMapper, AdminNoteEntity>
    implements AdminNoteService{

    /**
     * 每日4点
     * 删除2个月之前，审核状态为3的数据
     */
    @Scheduled(cron = "0 0 4 * * ?")
    public void clearProcessedWarnings(){
        Date olderMonthAgo = new Date(System.currentTimeMillis() - 60L*24*60*60*1000);
        QueryWrapper<AdminNoteEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("aduit_status", 3);
        queryWrapper.lt("updated_at", olderMonthAgo);
        List<AdminNoteEntity> list = baseMapper.selectList(queryWrapper);
        baseMapper.deleteBatchIds(list);
    }
}




