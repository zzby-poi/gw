package com.gw.admin.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author zzby
 * @version 创建时间： 2024/7/22 10:37
 */
@Data
public class AdminLoginReq {
    @NotBlank(message = "登录账号不能为空")
    @ApiModelProperty(value = "用户名",required = true)
    private String account;


    @NotNull(message = "密码不能为空")
    @ApiModelProperty(value = "密码",required = true)
    private String password;
}
