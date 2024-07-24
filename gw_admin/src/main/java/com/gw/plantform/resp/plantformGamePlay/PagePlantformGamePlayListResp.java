package com.gw.plantform.resp.plantformGamePlay;
import lombok.Data;

/**
 * @author zzby
 * @version 创建时间： 2024/7/23 10:02
 */
@Data
public class PagePlantformGamePlayListResp {
    private Long id;
    private String plantformName;
    private String gameName;
    private String gamePlayName;
    private Integer status;
    private Integer order;
}
