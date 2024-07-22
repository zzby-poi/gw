package com.gw.game.resp.gamePlayType;

import com.gw.base.entity.BaseEntity;
import lombok.Data;

/**
 * @author zzby
 * @version 创建时间： 2024/7/22 17:42
 */
@Data
public class PageGamePlayTypeLIstResp extends BaseEntity {
    private Long id;
    private String name;
    private String code;
    private Integer status;
}
