package com.gw.game.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gw.base.resp.ApiResp;
import com.gw.constans.ResCodeContants;
import com.gw.game.entity.*;
import com.gw.game.req.plantformGame.AddPlantformGameReq;
import com.gw.game.req.plantformGame.DeletePlantformGameReq;
import com.gw.game.req.plantformGame.PagePlantformGameListReq;
import com.gw.game.req.plantformGame.StatusPlantformGameReq;
import com.gw.game.req.plantformGamePlay.AddPlantformGamePlayReq;
import com.gw.game.req.plantformGamePlay.DeletePlantformGamePlayReq;
import com.gw.game.req.plantformGamePlay.StatusPlantformGamePlayReq;
import com.gw.game.resp.plantformGame.PagePlantformGameListResp;
import com.gw.game.service.GameInfoService;
import com.gw.game.service.PlantformGameService;
import com.gw.game.mapper.PlantformGameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author zzby
* @description 针对表【plantform_game(平台游戏关联表)】的数据库操作Service实现
* @createDate 2024-07-23 11:48:02
*/
@Service
public class PlantformGameServiceImpl extends ServiceImpl<PlantformGameMapper, PlantformGameEntity>
    implements PlantformGameService{
    @Autowired
    GameInfoService gameInfoService;
    /**
     * 分页平台游戏列表
     * @param req
     * @return
     */
    @Override
    public ApiResp<String> getPagePlantformGameList(PagePlantformGameListReq req) {
        PageHelper.startPage(req.getPageNo(),req.getPageSize());
        Page<PagePlantformGameListResp> list = (Page<PagePlantformGameListResp>)
                baseMapper.getPagePlantformGameList(req.getPlantformId(), req.getType(), req.getStatus());
        return ApiResp.page(list);
    }

    /**
     * 新增平台游戏玩法
     * @param req
     * @return
     */
    @Override
    public ApiResp<String> addPlantformGame(AddPlantformGameReq req) {
        List<GameInfos> gameInfos = req.getGameInfos();//游戏信息集合
        List<PlantformGameEntity> pgList=new ArrayList<>();
        if(gameInfos.isEmpty()){
            //遍历游戏玩法信息合集，创建并设置平台游戏玩法
            for (GameInfos infos : gameInfos) {
                PlantformGameEntity p=new PlantformGameEntity();
                p.setGameId(infos.getGameId());
                p.setStatus(infos.getStatus());
                p.setPlantformId(req.getPlantformId());
                pgList.add(p);
            }
            //批量存储
            saveBatch(pgList);
            return ApiResp.sucess();
        }
        return ApiResp.error(ResCodeContants.PARAM_ERROR,"参数错误");
    }

    /**
     * 启/停用平台游戏
     * 同时修改商户游戏关联信息、平台游戏玩法关联信息、商户游戏玩法关联平台
     * @param req
     * @return
     */
    @Override
    public ApiResp<String> statusPlantformGame(StatusPlantformGameReq req) {
        PlantformGameEntity pg = baseMapper.selectById(req.getPlantformId());
        //更新平台状态信息
        pg.setStatus(req.getStatus());
        baseMapper.updateById(pg);

        //TODO:修改商户游戏关联信息、平台游戏玩法关联信息、商户游戏玩法关联平台


        return ApiResp.sucess();
    }

    /**
     * 删除平台游戏
     * 同时删除商户游戏关联信息、平台游戏玩法关联信息、商户游戏玩法关联平台
     * @param req
     * @return
     */
    @Override
    public ApiResp<String> deletePlantformGame(DeletePlantformGameReq req) {
        QueryWrapper<PlantformGameEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("game_id", req.getGameId());
        queryWrapper.eq("plantform_id", req.getPlantformId());
        baseMapper.delete(queryWrapper);
        //TODO:删除商户游戏关联信息、平台游戏玩法关联信息、商户游戏玩法关联平台

        return ApiResp.sucess();
    }
}



