package com.gw.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gw.admin.req.AdminLogoutReq;
import com.gw.base.resp.ApiResp;
import com.gw.admin.entity.AdminUserEntity;
import com.gw.admin.req.AdminLoginReq;

/**
 * @author zzby
 * @version 创建时间： 2024/7/22 10:28
 */
public interface AdminUserService extends IService<AdminUserEntity> {
    ApiResp<String> login(AdminLoginReq req);

    ApiResp<String> logout(AdminLogoutReq req);
}
