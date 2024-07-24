package com.gw.plantform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gw.base.resp.ApiResp;
import com.gw.constans.ResCodeContants;
import com.gw.game.entity.*;
import com.gw.plantform.mapper.PlantformGamePlayMapper;
import com.gw.plantform.req.merchantGamePlay.AddMerchantGamePlayReq;
import com.gw.plantform.req.merchantGamePlay.DeleteMerchantGamePlayReq;
import com.gw.plantform.req.merchantGamePlay.PageMerchantGamePlayListReq;
import com.gw.plantform.req.merchantGamePlay.StatusMerchantGamePlayReq;
import com.gw.plantform.resp.merchantGamePlay.PageMerchantGamePlayListResp;
import com.gw.game.service.GamePlayService;
import com.gw.plantform.service.PlantformGamePlayService;
import com.gw.plantform.service.PlantformMerchantGamePlayService;
import com.gw.plantform.mapper.PlantformMerchantGamePlayMapper;
import com.gw.plantform.service.PlantformMerchantService;
import com.gw.plantform.entity.PlantformGamePlayEntity;
import com.gw.plantform.entity.PlantformMerchant;
import com.gw.plantform.entity.PlantformMerchantGamePlayEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author zzby
* @description 针对表【plantform_merchant_game_play(商户游戏玩法关联表)】的数据库操作Service实现
* @createDate 2024-07-23 16:41:38
*/
@Service
public class PlantformMerchantGamePlayServiceImpl extends ServiceImpl<PlantformMerchantGamePlayMapper, PlantformMerchantGamePlayEntity>
    implements PlantformMerchantGamePlayService{

    @Autowired
    PlantformMerchantService plantformMerchantService;//平台商户信息

    @Autowired
    PlantformGamePlayService plantformGamePlayService;//平台玩法
    @Autowired
    PlantformGamePlayMapper plantformGamePlayMapper;

    @Autowired
    GamePlayService gamePlayService;

    /**
     * 分页商户游戏玩法
     * 根据商户ID、游戏ID、状态分页搜索商户游戏玩法
     * @param req
     * @return
     */
    @Override
    public ApiResp getPageMerchantGamePlayList(PageMerchantGamePlayListReq req) {
        PageHelper.startPage(req.getPageNo(), req.getPageSize());
        Page<PageMerchantGamePlayListResp> list = (Page<PageMerchantGamePlayListResp>)
                baseMapper.getPageMerchantGamePlayList(req.getMerchantId(), req.getGameId(), req.getStatus());
        return ApiResp.page(list);
    }

    /**
     * 新增商户游戏玩法
     * 所选游戏玩法必须为商户上级平台启用状态的游戏玩法
     * @param req
     * @return
     */
    @Override
    public ApiResp addMerchantGamePlay(AddMerchantGamePlayReq req) {

        //先找到唯一的平台商户游戏字段
        QueryWrapper<PlantformMerchantGamePlayEntity> qw1 = new QueryWrapper<>();
        qw1.eq("merchant_id",req.getMerchantId());
        qw1.eq("game_id",req.getGamePlayInfos().getGameId());
        qw1.eq("game_play_id",req.getGamePlayInfos().getGamePlayId());
        PlantformMerchantGamePlayEntity pmgp =baseMapper.selectOne(qw1);
        if(pmgp!=null){
            return ApiResp.error(ResCodeContants.PARAM_ERROR,"该平台商户游戏玩法已存在");
        }else{
            pmgp=new PlantformMerchantGamePlayEntity();
        }

        //判断上级平台是否是启用状态
        //1.根据 平台商户id 查找所属平台id
        PlantformMerchant pm = plantformMerchantService.getById(req.getMerchantId());
        //2.根据 所属平台id 查找游戏玩法是否启用
        QueryWrapper<PlantformGamePlayEntity> qw2 = new QueryWrapper<>();
        qw2.eq("plantform_id",pm.getPlantformId());
        qw2.eq("game_id",req.getGamePlayInfos().getGameId());
        qw2.eq("status",1);
        PlantformGamePlayEntity pgp=plantformGamePlayMapper.selectOne(qw2);
        if(pgp==null){
            return ApiResp.error(ResCodeContants.PARAM_ERROR,"平台未启用该游戏玩法");
        }
        //插入
        pmgp.setMerchantId(req.getMerchantId());
        pmgp.setGameId(req.getGamePlayInfos().getGameId());
        pmgp.setGamePlayId(req.getGamePlayInfos().getGamePlayId());
        pmgp.setStatus(req.getGamePlayInfos().getStatus());
        baseMapper.insert(pmgp);
        return ApiResp.sucess();
    }

    /**
     * 启/停用商户游戏玩法
     * 对应游戏玩法类型状态是停用状态时不能启用该游戏玩法
     * @param req
     * @return
     */
    @Override
    public ApiResp statusMerchantGamePlay(StatusMerchantGamePlayReq req) {
        //根据游戏玩法id查找游戏玩法，并判断是否启用
        GamePlayEntity gamePlay = gamePlayService.getById(req.getGamePlayId());
        if(gamePlay==null || gamePlay.getStatus()==0){
            return ApiResp.error(ResCodeContants.PARAM_ERROR,"玩法未启用");
        }
        //根据商户id以及游戏玩法id查找
        QueryWrapper<PlantformMerchantGamePlayEntity> qw = new QueryWrapper<>();
        qw.eq("merchant_id",req.getMerchantId());
        qw.eq("game_play_id",req.getGamePlayId());
        PlantformMerchantGamePlayEntity plantformMerchantGamePlayEntity = baseMapper.selectOne(qw);
        if(plantformMerchantGamePlayEntity==null){
            return ApiResp.error(ResCodeContants.PARAM_ERROR,"参数错误");
        }
        plantformMerchantGamePlayEntity.setStatus(req.getStatus());
        baseMapper.updateById(plantformMerchantGamePlayEntity);
        return ApiResp.sucess();
    }

    /**
     * 删除商户游戏玩法
     * @param req
     * @return
     */
    @Override
    public ApiResp deleteMerchantGamePlay(DeleteMerchantGamePlayReq req) {
        //根据商户id以及游戏玩法id查找
        QueryWrapper<PlantformMerchantGamePlayEntity> qw = new QueryWrapper<>();
        qw.eq("merchant_id",req.getMerchantId());
        qw.eq("game_play_id",req.getGamePlayId());
        PlantformMerchantGamePlayEntity plantformMerchantGamePlayEntity = baseMapper.selectOne(qw);
        if(plantformMerchantGamePlayEntity==null){
            return ApiResp.error(ResCodeContants.PARAM_ERROR,"参数错误");
        }
        baseMapper.deleteById(plantformMerchantGamePlayEntity);
        return ApiResp.sucess();
    }
}



