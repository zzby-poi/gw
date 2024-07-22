package com.gw.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gw.base.entity.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * @author zzby
 * @version 创建时间： 2024/7/22 10:25
 */
@Data
@TableName("admin_user")
public class AdminUserEntity extends BaseEntity {
    @TableId(type = IdType.AUTO,value = "admin_id")
    private Long adminId;
    private String account;
    private String password;
    @TableField("nick_name")
    private String nickName;
    @TableField("action_status")
    private Integer actionStatus;
    @TableField("language_id")
    private Long languageId;
    @TableField("is_admin")
    private Integer isAdmin;
}
