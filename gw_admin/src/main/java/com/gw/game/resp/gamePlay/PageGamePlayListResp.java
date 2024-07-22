package com.gw.game.resp.gamePlay;
import lombok.Data;

import java.util.Date;

/**
 * @author zzby
 * @version 创建时间： 2024/7/22 15:31
 */
@Data
public class PageGamePlayListResp {
    private Long id;
    private String name;
    private String code;
    private Integer status;
    private Long gameId;
    private Long gamePlayTypeId;
    private String creator;
    private Date createdAt;
    private String updater;
    private Date updatedAt;
}
