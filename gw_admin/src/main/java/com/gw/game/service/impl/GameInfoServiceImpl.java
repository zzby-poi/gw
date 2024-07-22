package com.gw.game.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gw.base.resp.ApiResp;
import com.gw.constans.ResCodeContants;
import com.gw.game.entity.GameInfoEntity;
import com.gw.game.mapper.GameInfoMapper;
import com.gw.game.req.gameInfo.*;
import com.gw.game.resp.gameInfo.GetGameInfoListResp;
import com.gw.game.resp.gameInfo.PageGameInfoListResp;
import com.gw.game.service.GameInfoService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author zzby
 * @version 创建时间： 2024/7/22 11:15
 */
@Service
public class GameInfoServiceImpl extends ServiceImpl<GameInfoMapper, GameInfoEntity> implements GameInfoService {
    /**
     * 获取分页游戏信息列表
     * @param req
     * @return
     */
    @Override
    public ApiResp getPageGameInfoList(PageGameInfoListReq req) {
        //设置分页条件
        PageHelper.startPage(req.getPageNo(),req.getPageSize());
        //设置查询条件
//        QueryWrapper<GameInfoEntity> queryWrapper=new QueryWrapper<>();
//        if(req.getGameName()!=null){
//            queryWrapper.eq("name",req.getGameName());
//        }
//        if(req.getType()!=null){
//            queryWrapper.eq("type",req.getType());
//        }
//        if(req.getStatus()!=null){
//            queryWrapper.eq("status",req.getStatus());
//        }
        Page<PageGameInfoListResp> pageGameInfoListRespPage =(Page<PageGameInfoListResp>)
                baseMapper.pageGameInfoList(req.getGameName(), req.getStatus(), req.getType());
        return ApiResp.page(pageGameInfoListRespPage);
    }

    /**
     * 添加游戏信息
     * @param req
     * @return
     */
    @Override
    public ApiResp<String> addGameInfo(AddGameInfoReq req) {
        GameInfoEntity game=baseMapper.selectOne(Wrappers.<GameInfoEntity>lambdaQuery()
                .eq(GameInfoEntity::getName,req.getName()));
        //判断是否有重复的游戏名
        if(game!=null){
            return ApiResp.error(ResCodeContants.PARAM_ERROR,"存在重复的游戏名");
        }
        //新增游戏
        GameInfoEntity newGame=new GameInfoEntity(req);
        baseMapper.insert(newGame);

        return ApiResp.sucess(newGame);
    }

    /**
     * 修改游戏信息
     * @param req
     * @return
     */
    @Override
    public ApiResp<String> updateGameInfo(UpdateGameInfoReq req) {
        GameInfoEntity game=baseMapper.selectOne(Wrappers.<GameInfoEntity>lambdaQuery()
                .eq(GameInfoEntity::getId,req.getId()));
        //判断是否有该游戏
        if(game==null){
            return ApiResp.error(ResCodeContants.PARAM_ERROR,"不存在的游戏");
        }
        //更新游戏信息
        game.setName(req.getName());
        game.setStatus(req.getStatus());
        game.setIcon(req.getIcon());
        game.setOrder(req.getOrder());
        game.setType(req.getType());

        game.setUpdatedAt(new Date());
        baseMapper.updateById(game);
        return ApiResp.sucess(game);
    }

    /**
     * 删除游戏信息
     * @param req
     * @return
     */
    @Override
    public ApiResp<String> deleteGameInfo(DeleteGameInfoReq req) {
        GameInfoEntity game=baseMapper.selectOne(Wrappers.<GameInfoEntity>lambdaQuery()
                .eq(GameInfoEntity::getId,req.getId()));
        //判断是否有该游戏
        if(game==null){
            return ApiResp.error(ResCodeContants.PARAM_ERROR,"不存在的游戏");
        }
        baseMapper.deleteById(game);
        return ApiResp.sucess();
    }

    /**
     * 启/停用游戏信息
     * @param req
     * @return
     */
    @Override
    public ApiResp<String> statusGameInfo(StatusGameInfoReq req) {
        GameInfoEntity game=baseMapper.selectOne(Wrappers.<GameInfoEntity>lambdaQuery()
                .eq(GameInfoEntity::getId,req.getId()));
        //判断是否有该游戏
        if(game==null){
            return ApiResp.error(ResCodeContants.PARAM_ERROR,"不存在的游戏");
        }
        game.setStatus(req.getStatus());
        baseMapper.updateById(game);
        return ApiResp.sucess();
    }

    /**
     * 游戏信息列表
     * 根据游戏类型查询为正常状态的游戏列表，如果有传入平台ID则查询平台关联的正常状态的游戏列表
     * @param req
     * @return
     */
    @Override
    public ApiResp<String> getGameInfoList(GetGameInfoListReq req) {
        List<GetGameInfoListResp> gameInfoList = baseMapper.getGameInfoList(req.getPlantformId(), req.getType());
        return ApiResp.sucess(gameInfoList);
    }
}
