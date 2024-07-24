package com.gw.plantform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gw.base.resp.ApiResp;
import com.gw.constans.ResCodeContants;
import com.gw.plantform.mapper.PlantformGameMapper;
import com.gw.plantform.resp.merchantGame.PageMerchantGameListResp;
import com.gw.game.service.*;
import com.gw.plantform.mapper.PlantformMerchantGameMapper;
import com.gw.plantform.entity.PlantformGameEntity;
import com.gw.plantform.entity.PlantformMerchant;
import com.gw.plantform.entity.PlantformMerchantGameEntity;
import com.gw.plantform.req.merchantGame.*;
import com.gw.plantform.service.PlantformGameService;
import com.gw.plantform.service.PlantformMerchantGamePlayService;
import com.gw.plantform.service.PlantformMerchantGameService;
import com.gw.plantform.service.PlantformMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author zzby
* @description 针对表【plantform_merchant_game(商户游戏关联表)】的数据库操作Service实现
* @createDate 2024-07-23 17:42:55
*/
@Service
public class PlantformMerchantGameServiceImpl extends ServiceImpl<PlantformMerchantGameMapper, PlantformMerchantGameEntity>
    implements PlantformMerchantGameService {
    @Autowired
    PlantformMerchantService plantformMerchantService;//平台商户信息

    @Autowired
    PlantformGameService plantformGamePlayService;//平台玩法
    @Autowired
    PlantformGameMapper plantformGameMapper;

    @Autowired
    GamePlayService gamePlayService;

    @Autowired
    PlantformMerchantGamePlayService plantformMerchantGamePlayService;
    
    
    /**
     * 分页商户游戏列表
     * 根据商户ID、游戏名称、状态分页搜索商户游戏
     * @param req
     * @return
     */
    @Override
    public ApiResp getPageMerchantGameList(PageMerchantGameListReq req) {
        PageHelper.startPage(req.getPageNo(), req.getPageSize());
        Page<PageMerchantGameListResp> list = (Page<PageMerchantGameListResp>)
                baseMapper.getPageMerchantGameList(req.getMerchantId(), req.getGameId(), req.getStatus());
        return ApiResp.page(list);
    }

    /**
     * 新增商户游戏
     * 所选游戏必须为商户上级平台启用状态的游戏
     * @param req
     * @return
     */
    @Override
    public ApiResp addMerchantGame(AddMerchantGameReq req) {
        //先找到唯一的平台商户游戏字段
        QueryWrapper<PlantformMerchantGameEntity> qw1 = new QueryWrapper<>();
        qw1.eq("merchant_id",req.getMerchantId());
        qw1.eq("game_id",req.getGameId());
        PlantformMerchantGameEntity pmg =baseMapper.selectOne(qw1);
        if(pmg!=null){
            return ApiResp.error(ResCodeContants.PARAM_ERROR,"该平台商户游戏已存在");
        }else{
            pmg=new PlantformMerchantGameEntity();
        }
        //判断上级平台是否是启用状态
        //1.根据 平台商户id 查找所属平台id
        PlantformMerchant pm = plantformMerchantService.getById(req.getMerchantId());
        //2.根据 所属平台id 查找游戏是否启用
        QueryWrapper<PlantformGameEntity> qw2 = new QueryWrapper<>();
        qw2.eq("plantform_id",pm.getPlantformId());
        qw2.eq("game_id",req.getGameId());
        qw2.eq("status",1);
        PlantformGameEntity pgp=plantformGameMapper.selectOne(qw2);
        if(pgp==null){
            return ApiResp.error(ResCodeContants.PARAM_ERROR,"平台未启用该游戏");
        }
        //插入
        pmg.setMerchantId(req.getMerchantId());
        pmg.setGameId(req.getGameId());
        pmg.setStatus(req.getStatus());
        baseMapper.insert(pmg);
        return ApiResp.sucess();
    }

    /**
     * 修改商户游戏
     * 所选游戏必须为商户上级平台启用状态的游戏
     * @param req
     * @return
     */
    @Override
    public ApiResp updateMerchantGame(UpdateMerchantGameReq req) {
        //先找到唯一的平台商户游戏字段
        QueryWrapper<PlantformMerchantGameEntity> qw1 = new QueryWrapper<>();
        qw1.eq("merchant_id",req.getMerchantId());
        qw1.eq("game_id",req.getGameId());
        PlantformMerchantGameEntity pmg =baseMapper.selectOne(qw1);
        if(pmg!=null){
            return ApiResp.error(ResCodeContants.PARAM_ERROR,"该平台商户游戏已存在");
        }else{
            pmg=new PlantformMerchantGameEntity();
        }
        //判断上级平台是否是启用状态
        //1.根据 平台商户id 查找所属平台id
        PlantformMerchant pm = plantformMerchantService.getById(req.getMerchantId());
        //2.根据 所属平台id 查找游戏是否启用
        QueryWrapper<PlantformGameEntity> qw2 = new QueryWrapper<>();
        qw2.eq("plantform_id",pm.getPlantformId());
        qw2.eq("game_id",req.getGameId());
        qw2.eq("status",1);
        PlantformGameEntity pgp=plantformGameMapper.selectOne(qw2);
        if(pgp==null){
            return ApiResp.error(ResCodeContants.PARAM_ERROR,"平台未启用该游戏");
        }
        //插入
        pmg.setMerchantId(req.getMerchantId());
        pmg.setGameId(req.getGameId());
        pmg.setStatus(req.getStatus());
        baseMapper.updateById(pmg);
        return ApiResp.sucess();
    }

    /**
     * 启/停用商户游戏
     * 同步修改商户游戏玩法关联信息
     * @param req
     * @return
     */
    @Override
    public ApiResp statusMerchantGame(StatusMerchantGameReq req) {
        //修改商户游戏表
        QueryWrapper<PlantformMerchantGameEntity> qw = new QueryWrapper<>();
        qw.eq("merchant_id",req.getMerchantId());
        PlantformMerchantGameEntity pmg = baseMapper.selectOne(qw);
        pmg.setStatus(req.getStatus());
        baseMapper.updateById(pmg);

        //TODO:修改商户游戏玩法关联信息
        return ApiResp.sucess();
    }

    /**
     * 删除商户游戏玩法
     * @param req
     * @return
     */
    @Override
    public ApiResp deleteMerchantGame(DeleteMerchantGameReq req) {
        QueryWrapper<PlantformMerchantGameEntity> qw = new QueryWrapper<>();
        qw.eq("merchant_id",req.getMerchantId());
        PlantformMerchantGameEntity plantformMerchantGameEntity = baseMapper.selectOne(qw);
        if(plantformMerchantGameEntity==null){
            return ApiResp.error(ResCodeContants.PARAM_ERROR,"参数错误");
        }
        baseMapper.deleteById(plantformMerchantGameEntity);

        //TODO:删除商户游戏玩法关联信息
        return ApiResp.sucess();
    }
}




