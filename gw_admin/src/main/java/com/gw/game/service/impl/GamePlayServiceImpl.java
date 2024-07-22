package com.gw.game.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gw.base.resp.ApiResp;
import com.gw.constans.ResCodeContants;
import com.gw.game.entity.GamePlayEntity;
import com.gw.game.mapper.GamePlayMapper;
import com.gw.game.req.gamePlay.*;
import com.gw.game.resp.gamePlay.GetGamePlayListResp;
import com.gw.game.resp.gamePlay.PageGamePlayListResp;
import com.gw.game.service.GamePlayService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author zzby
* @description 针对表【game_play(游戏玩法)】的数据库操作Service实现
* @createDate 2024-07-22 15:15:56
*/
@Service
public class GamePlayServiceImpl extends ServiceImpl<GamePlayMapper, GamePlayEntity> implements GamePlayService {

    /**
     * 分页游戏玩法列表
     * @param req
     * @return
     */
    @Override
    public ApiResp<String> getPageGamePlayList(PageGamePlayListReq req) {
        //设置分页条件
        PageHelper.startPage(req.getPageNo(),req.getPageSize());
        Page<PageGamePlayListResp> pageGamePlayRespPageList = (Page<PageGamePlayListResp>)
        baseMapper.getPageGamePlayList(req.getGamePlayName(),req.getStatus(),req.getGameId());
        return ApiResp.page(pageGamePlayRespPageList);
    }

    /**
     * 新增游戏玩法
     * @param req
     * @return
     */
    @Override
    public ApiResp<String> addGamePlay(AddGamePlayReq req) {
        GamePlayEntity gamePlay=baseMapper.selectOne(Wrappers.<GamePlayEntity>lambdaQuery()
                .eq(GamePlayEntity::getName,req.getName()));
        //判断是否有重复的游戏名
        if(gamePlay!=null){
            return ApiResp.error(ResCodeContants.PARAM_ERROR,"重复的游戏名称");
        }
        GamePlayEntity newGamePlay=new GamePlayEntity();
        newGamePlay.setName(req.getName());
        newGamePlay.setStatus(req.getStatus());
        newGamePlay.setGameId(req.getGameId());
        newGamePlay.setGamePlayTypeId(req.getGamePlayTypeId());
        baseMapper.insert(newGamePlay);
        return ApiResp.sucess(newGamePlay);
    }

    /**
     * 修改游戏玩法
     * @param req
     * @return
     */
    @Override
    public ApiResp<String> updateGamePlay(UpdateGamePlayReq req) {
        GamePlayEntity gamePlay=baseMapper.selectOne(Wrappers.<GamePlayEntity>lambdaQuery()
                .eq(GamePlayEntity::getId,req.getId()));
        //判断游戏是否存在
        if(gamePlay==null){
            return ApiResp.error(ResCodeContants.PARAM_ERROR,"不存在的游戏");
        }
        gamePlay.setName(req.getName());
        gamePlay.setStatus(req.getStatus());
        gamePlay.setGameId(req.getGameId());
        gamePlay.setGamePlayTypeId(req.getGamePlayTypeId());
        baseMapper.updateById(gamePlay);
        return ApiResp.sucess(gamePlay);
    }

    /**
     * 删除游戏玩法
     * @param req
     * @return
     */
    @Override
    public ApiResp<String> deleteGamePlay(DeleteGamePlayReq req) {
        baseMapper.delete(Wrappers.<GamePlayEntity>lambdaQuery()
                .eq(GamePlayEntity::getId,req.getId()));
        return ApiResp.sucess();
    }

    /**
     * 启/停用游戏玩法
     * @param req
     * @return
     */
    @Override
    public ApiResp<String> statusGamePlay(StatusGamePlayReq req) {
        GamePlayEntity gamePlay=baseMapper.selectOne(Wrappers.<GamePlayEntity>lambdaQuery()
                .eq(GamePlayEntity::getId,req.getId()));
        //判断游戏是否存在
        if(gamePlay==null){
            return ApiResp.error(ResCodeContants.PARAM_ERROR,"不存在的游戏");
        }
        gamePlay.setStatus(req.getStatus());
        baseMapper.updateById(gamePlay);
        return ApiResp.sucess();
    }

    /**
     * 游戏玩法列表
     * 根据游戏ID查询正常状态的游戏玩法列表，如果传入平台ID则查询该平台管理的游戏玩法列表
     * @param req
     * @return
     */
    @Override
    public ApiResp<String> getGamePlayList(GetGamePlayListReq req) {
        List<GetGamePlayListResp> gamePlayList = baseMapper.getGamePlayList(req.getGameId(), req.getPlantformId());
        return ApiResp.sucess(gamePlayList);
    }
}




