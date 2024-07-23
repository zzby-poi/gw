package com.gw.game.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gw.base.resp.ApiResp;
import com.gw.game.entity.PlantformInfoEntity;
import com.gw.game.req.plantformGame.PagePlantformGameListReq;
import com.gw.game.resp.plantformGame.PagePlantformGameListResp;
import com.gw.game.resp.plantformGamePlay.PagePlantformGamePlayListResp;
import com.gw.game.service.PlantformInfoService;
import com.gw.game.mapper.PlantformInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author zzby
* @description 针对表【plantform_info(平台信息)】的数据库操作Service实现
* @createDate 2024-07-23 11:35:43
*/
@Service
public class PlantformInfoServiceImpl extends ServiceImpl<PlantformInfoMapper, PlantformInfoEntity>
    implements PlantformInfoService{

}




