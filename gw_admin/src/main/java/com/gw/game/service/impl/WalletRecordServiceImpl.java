package com.gw.game.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gw.game.entity.WalletRecordEntity;
import com.gw.game.service.WalletRecordService;
import com.gw.game.mapper.WalletRecordMapper;
import com.gw.util.RedisUtils;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author zzby
* @description 针对表【wallet_record(钱包余额变动记录)】的数据库操作Service实现
* @createDate 2024-07-24 09:53:51
*/
@Service
public class WalletRecordServiceImpl extends ServiceImpl<WalletRecordMapper, WalletRecordEntity>
    implements WalletRecordService{

    /**
     * 钱包账变记录
     * 判断redis中会员会员账变数据是否达到或超过500条，如果满足取出数据并添加到会员账变记录表，完成后删除redis。如不满足数据添加到redis中
     */
    @Override
    public void change() {
        RedisUtils redisUtils=new RedisUtils();
        //TODO:
        if(redisUtils.getListSize("walletChange")>=500){
            List<Object> list= redisUtils.getAllList("walletChange");
            //将集合存入表中
        }else{
            //如果没满足，则存入redis
            redisUtils.pushList("walletChange",new ArrayList<Object>());
        }
    }
}




