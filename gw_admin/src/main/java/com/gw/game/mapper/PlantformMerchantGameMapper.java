package com.gw.game.mapper;

import com.gw.game.entity.PlantformMerchantGameEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gw.game.resp.merchantGame.PageMerchantGameListResp;
import com.gw.game.resp.merchantGamePlay.PageMerchantGamePlayListResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author zzby
* @description 针对表【plantform_merchant_game(商户游戏关联表)】的数据库操作Mapper
* @createDate 2024-07-23 17:42:55
* @Entity com.gw.game.entity.PlantformMerchantGame
*/
public interface PlantformMerchantGameMapper extends BaseMapper<PlantformMerchantGameEntity> {
    List<PageMerchantGameListResp> getPageMerchantGameList(@Param("merchantId") Long merchantId,
                                                               @Param("gameId") Long gameId,
                                                               @Param("status") Integer status);
}




