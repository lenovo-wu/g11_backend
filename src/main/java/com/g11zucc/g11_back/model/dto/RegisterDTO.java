package com.g11zucc.g11_back.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class RegisterDTO {
    @NotEmpty(message = "请输入您的学号")
    @Length(min = 4, max = 8,message = "学号格式不正确")
    private String stunum;

    @NotEmpty(message = "请输入密码")
    @Length(min = 6, max = 20, message = "长度在6-20")
    private String pass;

    @NotEmpty(message = "请再次输入密码")
    @Length(min = 6, max = 20, message = "长度在6-20")
    private String checkPass;

    @NotEmpty(message = "请输入昵称")
    @Length(min = 2, max = 10, message = "长度在2-10")
    private String othername;

    @NotEmpty(message = "请选择性别")
    private String sex;



    private String code;
}
