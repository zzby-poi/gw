package com.gw.plantform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gw.base.resp.ApiResp;
import com.gw.constans.ResCodeContants;
import com.gw.game.entity.GamePlayEntity;
import com.gw.game.entity.GamePlayInfos;
import com.gw.plantform.entity.PlantformGamePlayEntity;
import com.gw.game.mapper.GamePlayMapper;
import com.gw.plantform.entity.PlantformMerchantGameEntity;
import com.gw.plantform.entity.PlantformMerchantGamePlayEntity;
import com.gw.plantform.mapper.PlantformGamePlayMapper;
import com.gw.plantform.req.plantformGamePlay.AddPlantformGamePlayReq;
import com.gw.plantform.req.plantformGamePlay.DeletePlantformGamePlayReq;
import com.gw.plantform.req.plantformGamePlay.PagePlantformGamePlayListReq;
import com.gw.plantform.req.plantformGamePlay.StatusPlantformGamePlayReq;
import com.gw.plantform.resp.plantformGamePlay.PagePlantformGamePlayListResp;
import com.gw.game.service.GamePlayService;
import com.gw.plantform.service.PlantformGamePlayService;
import com.gw.plantform.service.PlantformMerchantGamePlayService;
import com.gw.plantform.service.PlantformMerchantGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author zzby
* @description 针对表【plantform_game(平台游戏关联表)】的数据库操作Service实现
* @createDate 2024-07-23 09:43:35
*/
@Service
public class PlantformGamePlayPlayServiceImpl extends ServiceImpl<PlantformGamePlayMapper, PlantformGamePlayEntity>
    implements PlantformGamePlayService {
    @Autowired
    GamePlayService gamePlayService;
    @Autowired
    GamePlayMapper gamePlayMapper;

    @Autowired
    PlantformMerchantGamePlayService plantformMerchantGamePlayService;

    /**
     * 分页平台游戏列表
     * 根据平台ID、游戏类型、状态分页搜索拥有游戏信息分页列表
     * @param req
     * @return PagePlantformGameListResp
     */
    @Override
    public ApiResp<String> getPagePlantformGamePlayList(PagePlantformGamePlayListReq req) {
        PageHelper.startPage(req.getPageNo(),req.getPageSize());
        Page<PagePlantformGamePlayListResp> list = (Page<PagePlantformGamePlayListResp>)
                baseMapper.getPagePlantformGamePlayList(req.getPlantformId(),req.getGameId(), req.getStatus());
        return ApiResp.page(list);
    }

    /**
     * 新增平台游戏玩法
     * @param req
     * @return
     */
    @Override
    public ApiResp<String> addPlantformGamePlay(AddPlantformGamePlayReq req) {
        List<GamePlayInfos> gamePlayInfos = req.getGamePlayInfos();//游戏玩法集合

        List<PlantformGamePlayEntity> pgList=new ArrayList<>();//平台游戏玩法集合

        if(gamePlayInfos.isEmpty()){
            //遍历游戏玩法信息合集，创建并设置平台游戏玩法
            for (GamePlayInfos infos : gamePlayInfos) {
                PlantformGamePlayEntity p=new PlantformGamePlayEntity();
                p.setGamePlayId(infos.getGamePlayId());
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
     * 启/停用平台游戏玩法
     * 1.对应游戏玩法类型状态未启用状态时不能启用该游戏玩法
     * 2.同时修改商户游戏玩法关联信息中对应玩法为相应状态
     * @param req
     * @return
     */
    @Override
    public ApiResp<String> statusPlantformGamePlay(StatusPlantformGamePlayReq req) {
        GamePlayEntity gamePlay = gamePlayService.getById(req.getGamePlayId());
        PlantformGamePlayEntity pg = baseMapper.selectById(req.getPlantformId());
        //要修改状态为0时，直接修改
        if(req.getStatus()==0){
            pg.setStatus(0);
        }
        //如果游戏玩法类型状态启用，则可以修改
        if(gamePlay.getStatus() == 1){
            pg.setStatus(req.getStatus());
        }
        baseMapper.updateById(pg);
        //TODO:修改商户游戏玩法关联信息中对应玩法为相应状态
        PlantformMerchantGamePlayEntity pmgpEntity= plantformMerchantGamePlayService.getBaseMapper().selectOne(
                Wrappers.<PlantformMerchantGamePlayEntity>lambdaQuery().eq(PlantformMerchantGamePlayEntity::getMerchantId,
                        pg.getId()));
        pmgpEntity.setStatus(req.getStatus());
        plantformMerchantGamePlayService.getBaseMapper().updateById(pmgpEntity);
        return ApiResp.sucess();
    }

    /**
     * 删除平台游戏玩法
     * 1.同时删除商户游戏玩法关联信息
     * @param req
     * @return
     */
    @Override
    public ApiResp<String> deletePlantformGamePlay(DeletePlantformGamePlayReq req) {
        QueryWrapper<PlantformGamePlayEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("game_play_id", req.getGamePlayId());
        queryWrapper.eq("plantform_id", req.getPlantformId());
        baseMapper.delete(queryWrapper);
        //TODO:删除商户游戏玩法关联信息
        PlantformMerchantGamePlayEntity pmgpEntity= plantformMerchantGamePlayService.getBaseMapper().selectOne(
                Wrappers.<PlantformMerchantGamePlayEntity>lambdaQuery().eq(PlantformMerchantGamePlayEntity::getGamePlayId,
                        req.getGamePlayId()));
        plantformMerchantGamePlayService.getBaseMapper().deleteById(pmgpEntity);

        return ApiResp.sucess();
    }
}




