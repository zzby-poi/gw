package com.gw.admin.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author zzby
 * @version 创建时间： 2024/7/22 11:01
 */
@Data
public class AdminLogoutReq {
    @NotNull(message = "登录账号不能为空")
    @ApiModelProperty(value = "用户名",required = true)
    private String account;

    @NotNull(message = "jwt不能为空")
    @ApiModelProperty(value = "jwt",required = true)
    private String token;
}
