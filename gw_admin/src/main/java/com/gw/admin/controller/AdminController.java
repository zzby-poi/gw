package com.gw.admin.controller;

import com.gw.admin.req.AdminLogoutReq;
import com.gw.base.resp.ApiResp;
import com.gw.admin.req.AdminLoginReq;
import com.gw.admin.service.AdminUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzby
 * @version 创建时间： 2024/7/22 10:31
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminUserService adminUserService;

    @PostMapping("/login")
    @ApiOperation(value = "管理员登录")
    public ApiResp<String> login(AdminLoginReq req){
        return adminUserService.login(req);
    }

    @GetMapping("/logout")
    @ApiOperation(value = "管理员登出")
    public ApiResp<String> logout(AdminLogoutReq req){
        return adminUserService.logout(req);
    }
}
