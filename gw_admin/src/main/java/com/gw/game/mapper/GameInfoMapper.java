package com.gw.game.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gw.game.entity.GameInfoEntity;
import com.gw.game.resp.gameInfo.GetGameInfoListResp;
import com.gw.game.resp.gameInfo.PageGameInfoListResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zzby
 * @version 创建时间： 2024/7/22 11:16
 */
@Mapper
public interface GameInfoMapper extends BaseMapper<GameInfoEntity> {

    /**
     * 分页查找游戏列表
     * @param gameName
     * @param status
     * @param type
     * @return
     */
    List<PageGameInfoListResp> pageGameInfoList(@Param("gameName") String gameName,
                                            @Param("status") Integer status,
                                            @Param("type") Integer type);

    /**
     * 游戏信息列表
     * @param plantformId
     * @param type
     * @return
     */
    List<GetGameInfoListResp> getGameInfoList(@Param("plantformId") Long plantformId,@Param("type") Integer type);
}

