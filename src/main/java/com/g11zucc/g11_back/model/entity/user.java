package com.g11zucc.g11_back.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;


@Data
@Builder
@Accessors(chain = true)
@TableName("user")
@NoArgsConstructor
@AllArgsConstructor
public class user implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键 用户id（学号）
     */
    @TableId(value = "user_id")
    private String UserId;

    /**
     * 用户昵称
     */
    @TableField("user_name")
    private String UserName;

    /**
     * 用户密码
     */
    @TableField("user_pwd")
    private String UserPwd;

    /**
     * 注册时间
     */
    @TableField(value = "user_registertime", fill = FieldFill.INSERT)
    private Date UserRegistertime;


    /**
     * 用户状态，1为正常2为冷冻3为封禁
     */
    @TableField("user_state")
    private int UserState;

    /**
     * 用户性别，1男2女
     */
    @TableField("user_sex")
    private int UserSex;

    /**
     * 用户权限，1普通用户2管理员
     */
    @TableField("user_jurisdiction")
    private int UserJurisdiction;

    /**
     * 用户个性签名
     */
    @TableField("user_signature")
    private String UserSignature;
}

