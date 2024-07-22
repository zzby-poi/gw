package com.gw.game.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gw.game.entity.GamePalyTypeEntity;

import com.gw.game.resp.gamePlayType.PageGamePlayTypeLIstResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author zzby
* @description 针对表【game_paly_type(游戏玩法配置)】的数据库操作Mapper
* @createDate 2024-07-22 16:29:07
* @Entity game.entity.GamePalyType
*/
@Mapper
public interface GamePalyTypeMapper extends BaseMapper<GamePalyTypeEntity> {
    List<PageGamePlayTypeLIstResp> pageGamePlayTypeList(@Param("name") String name,
                                                        @Param("code") String code,
                                                        @Param("status") Integer status);
}




