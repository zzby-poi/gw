package com.gw.game.mapper;

import com.gw.game.entity.PlantformMerchantGamePlayEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gw.game.resp.merchantGamePlay.PageMerchantGamePlayListResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author zzby
* @description 针对表【plantform_merchant_game_play(商户游戏玩法关联表)】的数据库操作Mapper
* @createDate 2024-07-23 16:41:38
* @Entity com.gw.game.entity.PlantformMerchantGamePlay
*/
public interface PlantformMerchantGamePlayMapper extends BaseMapper<PlantformMerchantGamePlayEntity> {

    List<PageMerchantGamePlayListResp> getPageMerchantGamePlayList(@Param("merchantId") Long merchantId,
                                                                   @Param("gameId") Long gameId,
                                                                   @Param("status") Integer status);
}




