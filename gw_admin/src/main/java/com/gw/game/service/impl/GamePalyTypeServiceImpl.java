package com.gw.game.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gw.base.resp.ApiResp;
import com.gw.constans.ResCodeContants;
import com.gw.game.entity.GamePalyTypeEntity;
import com.gw.game.entity.GamePlayEntity;
import com.gw.game.mapper.GamePalyTypeMapper;
import com.gw.game.req.gamePlayType.*;
import com.gw.game.resp.gamePlayType.PageGamePlayTypeLIstResp;
import com.gw.game.service.GamePalyTypeService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author zzby
* @description 针对表【game_paly_type(游戏玩法配置)】的数据库操作Service实现
* @createDate 2024-07-22 16:29:07
*/
@Service
public class GamePalyTypeServiceImpl extends ServiceImpl<GamePalyTypeMapper, GamePalyTypeEntity> implements GamePalyTypeService {

    /**
     * 分页游戏玩法类型列表
     * @param req
     * @return
     */
    @Override
    public ApiResp<String> getPageGamePlayTypeList(PageGamePlayTypeListReq req) {
        PageHelper.startPage(req.getPageNo(),req.getPageSize());
        Page<PageGamePlayTypeLIstResp> list=(Page<PageGamePlayTypeLIstResp>)
            baseMapper.pageGamePlayTypeList(req.getName(), req.getCode(),req.getStatus());
        return ApiResp.page(list);
    }

    /**
     * 新增游戏玩法类型
     * @param req
     * @return
     */
    @Override
    public ApiResp<String> addGamePlayType(AddGamePlayTypeReq req) {
        GamePalyTypeEntity game=baseMapper.selectOne(Wrappers.<GamePalyTypeEntity>lambdaQuery()
                .eq(GamePalyTypeEntity::getName,req.getName()));
        if(game!=null){
            ApiResp.error(ResCodeContants.PARAM_ERROR,"游戏玩法类型名称已存在");
        }
        game=new GamePalyTypeEntity();
        game.setName(req.getName());
        game.setCode(req.getCode());
        game.setStatus(req.getStatus());
        baseMapper.insert(game);
        return ApiResp.sucess(game);
    }

    /**
     * 修改游戏玩法类型
     * @param req
     * @return
     */
    @Override
    public ApiResp<String> updateGamePlayType(UpdateGamePlayTypeReq req) {
        GamePalyTypeEntity game=baseMapper.selectOne(Wrappers.<GamePalyTypeEntity>lambdaQuery()
                .eq(GamePalyTypeEntity::getId,req.getId()));
        if(game==null){
            ApiResp.error(ResCodeContants.PARAM_ERROR,"游戏玩法类型不存在");
        }
        game.setName(req.getName());
        game.setCode(req.getCode());
        game.setStatus(req.getStatus());
        baseMapper.updateById(game);
        return ApiResp.sucess(game);
    }

    /**
     * 删除游戏玩法类型
     * @param req
     * @return
     */
    @Override
    public ApiResp<String> deleteGamePlayType(DeleteGamePlayTypeReq req) {
        baseMapper.delete(Wrappers.<GamePalyTypeEntity>lambdaQuery()
                .eq(GamePalyTypeEntity::getId,req.getId()));
        return ApiResp.sucess();
    }

    /**
     * 启/停用游戏玩法类型
     * @param req
     * @return
     */
    @Override
    public ApiResp<String> statusGamePlayType(StatusGamePlayTypeReq req) {
        GamePalyTypeEntity game=baseMapper.selectOne(Wrappers.<GamePalyTypeEntity>lambdaQuery()
                .eq(GamePalyTypeEntity::getId,req.getId()));
        if(game==null){
            ApiResp.error(ResCodeContants.PARAM_ERROR,"游戏玩法类型不存在");
        }
        game.setStatus(req.getStatus());
        baseMapper.updateById(game);
        return ApiResp.sucess();
    }

    /**
     * 启用状态的游戏玩法类型列表
     * @return
     */
    @Override
    public ApiResp<String> enableGamePlayTypeList() {
        List<GamePalyTypeEntity> list = baseMapper.selectList(Wrappers.<GamePalyTypeEntity>lambdaQuery()
                .eq(GamePalyTypeEntity::getStatus, 1));
        return ApiResp.sucess(list);
    }

    /**
     * 根据游戏ID查询启用状态的游戏玩法类型列表
     * @return req
     */
    @Override
    public ApiResp<String> enableGamePlayTypeListByGameId(EnableGamePlayTypeListByGameIdReq req) {
        QueryWrapper queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("status",1);
        queryWrapper.eq("game_id",req.getGameId());
        List<GamePalyTypeEntity> list = baseMapper.selectList(queryWrapper);
        return ApiResp.sucess(list);
    }
}




