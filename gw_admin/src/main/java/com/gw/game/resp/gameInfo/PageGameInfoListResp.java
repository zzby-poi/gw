package com.gw.game.resp.gameInfo;

import lombok.Data;

import java.util.Date;

/**
 * @author zzby
 * @version 创建时间： 2024/7/22 11:36
 */
@Data
public class PageGameInfoListResp {
    private Long id;
    private String name;
    private String code;
    private Integer status;
    private String icon;
    private Integer order;
    private Integer type;
    private String creator;
    private String updater;
    private Date created_at;
    private Date updated_at;
}
