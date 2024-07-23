package com.gw.game.resp.merchantGamePlay;

import lombok.Data;

/**
 * @author zzby
 * @version 创建时间： 2024/7/23 16:48
 */
@Data
public class PageMerchantGamePlayListResp {
    private Long id;
    private String merchantName;
    private String gameName;
    private String gamePlayName;
    private Integer status;
    private Integer order;
}
