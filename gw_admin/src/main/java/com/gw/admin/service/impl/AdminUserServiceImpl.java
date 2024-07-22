package com.gw.admin.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gw.admin.req.AdminLogoutReq;
import com.gw.base.resp.ApiResp;
import com.gw.constans.ResCodeContants;
import com.gw.dto.LoginDto;
import com.gw.admin.entity.AdminUserEntity;
import com.gw.admin.mapper.AdminUserMapper;
import com.gw.admin.req.AdminLoginReq;
import com.gw.admin.service.AdminUserService;
import com.gw.util.JWTTokenUtil;
import com.gw.util.RedisUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zzby
 * @version 创建时间： 2024/7/22 10:29
 */
@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUserEntity> implements AdminUserService {
    /**
     * 管理员登录
     * @param req
     * @return
     */
    @Override
    public ApiResp<String> login(AdminLoginReq req) {
        AdminUserEntity admin=baseMapper.selectOne(Wrappers.<AdminUserEntity>lambdaQuery().
                eq(AdminUserEntity::getAccount,req.getAccount()));//根据登录账号查找管理员对象
        if(admin!=null){
            if(req.getPassword().equals(admin.getPassword())){//如果密码匹配则登陆成功
                //生产一个jwt
                LoginDto dto=new LoginDto();
                dto.setUserId(admin.getAdminId());
                dto.setIsAdmin(1);
                String token= JWTTokenUtil.createAccessToken(dto);

                //返回jwt
                Map map=new HashMap<String,String>();
                map.put("token",token);
                return ApiResp.sucess(map);
            }
        }
        return ApiResp.error(ResCodeContants.AUTH_ERROR,"error");
    }


    /**
     * 管理员登出
     * @param req
     * @return
     */
    @Override
    public ApiResp<String> logout(AdminLogoutReq req) {
        //将token存入redis黑名单
        RedisUtils redisUtils=new RedisUtils();
        redisUtils.set(req.getAccount(),req.getToken());
        return ApiResp.sucess();
    }
}
