package com.gw.plantform.mapper;

import com.gw.plantform.entity.PlantformInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gw.plantform.resp.plantformGame.PagePlantformGameListResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author zzby
* @description 针对表【plantform_info(平台信息)】的数据库操作Mapper
* @createDate 2024-07-23 11:35:43
* @Entity com.gw.game.entity.PlantformInfo
*/
public interface PlantformInfoMapper extends BaseMapper<PlantformInfoEntity> {

    List<PagePlantformGameListResp> getPagePlantformGameList(@Param("plantformId") Long plantformId,
                                                             @Param("type") Integer type,
                                                             @Param("status") Integer status);
}




