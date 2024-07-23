package com.gw.game.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gw.base.resp.ApiResp;
import com.gw.constans.ResCodeContants;
import com.gw.game.entity.GamePlayEntity;
import com.gw.game.entity.PlantformGamePlayEntity;
import com.gw.game.entity.PlantformMerchant;
import com.gw.game.entity.PlantformMerchantGamePlayEntity;
import com.gw.game.mapper.PlantformGamePlayMapper;
import com.gw.game.req.merchantGamePlay.AddMerchantGamePlayReq;
import com.gw.game.req.merchantGamePlay.DeleteMerchantGamePlayReq;
import com.gw.game.req.merchantGamePlay.PageMerchantGamePlayListReq;
import com.gw.game.req.merchantGamePlay.StatusMerchantGamePlayReq;
import com.gw.game.resp.merchantGamePlay.PageMerchantGamePlayListResp;
import com.gw.game.service.GamePlayService;
import com.gw.game.service.PlantformGamePlayService;
import com.gw.game.service.PlantformMerchantGamePlayService;
import com.gw.game.mapper.PlantformMerchantGamePlayMapper;
import com.gw.game.service.PlantformMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        PlantformMerchantGamePlayEntity merchantGamePlayEntity =baseMapper.selectById(req.getMerchantId());
        if(merchantGamePlayEntity==null){
            return ApiResp.error(ResCodeContants.PARAM_ERROR,"无效的平台商户id");
        }
        //1.根据 平台商户id 查找所属平台id
        PlantformMerchant pm = plantformMerchantService.getById(req.getMerchantId());
        //2.根据 所属平台id 查找游戏玩法是否启用
        QueryWrapper<PlantformGamePlayEntity> qw = new QueryWrapper<>();
        qw.eq("plantform_id",pm.getPlantformId());
        qw.eq("game_id",req.getGamePlayInfos().getGameId());
        qw.eq("status",1);
        PlantformGamePlayEntity pgp=plantformGamePlayMapper.selectOne(qw);
        if(pgp==null){
            return ApiResp.error(ResCodeContants.PARAM_ERROR,"平台未启用该游戏玩法");
        }
        merchantGamePlayEntity.setMerchantId(req.getMerchantId());
        merchantGamePlayEntity.setGameId(req.getGamePlayInfos().getGameId());
        merchantGamePlayEntity.setGamePlayId(req.getGamePlayInfos().getGamePlayId());
        merchantGamePlayEntity.setStatus(req.getGamePlayInfos().getStatus());
        baseMapper.insert(merchantGamePlayEntity);
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




