package com.gw.game.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gw.base.resp.ApiResp;
import com.gw.game.entity.PlantformGameEntity;
import com.gw.game.mapper.PlantformGameMapper;
import com.gw.game.req.plantformGame.PagePlantformGameListReq;
import com.gw.game.resp.plantformGame.PagePlantformGameListResp;
import com.gw.game.service.PlantformGameService;
import org.springframework.stereotype.Service;

/**
* @author zzby
* @description 针对表【plantform_game(平台游戏关联表)】的数据库操作Service实现
* @createDate 2024-07-23 09:43:35
*/
@Service
public class PlantformGameServiceImpl extends ServiceImpl<PlantformGameMapper, PlantformGameEntity>
    implements PlantformGameService {

    /**
     * 分页平台游戏列表
     * 根据平台ID、游戏类型、状态分页搜索拥有游戏信息分页列表
     * @param req
     * @return PagePlantformGameListResp
     */
    @Override
    public ApiResp<String> getPagePlantformGameList(PagePlantformGameListReq req) {
        PageHelper.startPage(req.getPageNo(),req.getPageSize());

        Page<PagePlantformGameListResp> list = (Page<PagePlantformGameListResp>)
                baseMapper.getPagePlantformGameList(req.getPlantformId(), req.getType(), req.getStatus());

        return ApiResp.page(list);
    }
}




