package com.gw.plantform.resp.merchantGame;

import lombok.Data;

/**
 * @author zzby
 * @version 创建时间： 2024/7/23 16:48
 */
@Data
public class PageMerchantGameListResp {
    private Long merchantId;
    private String merchantName;
    private String gameName;
    private String gamePlayName;
    private Integer status;
    private Integer order;
}
