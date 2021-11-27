package com.g11zucc.g11_back.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class RegisterDTO {
    @NotEmpty(message = "请输入城院邮箱")
    @Email(message = "邮箱格式不正确")
    private String email;

    @NotEmpty(message = "请输入密码")
    @Length(min = 6, max = 20, message = "长度在6-20")
    private String pass;

    @NotEmpty(message = "请再次输入密码")
    @Length(min = 6, max = 20, message = "长度在6-20")
    private String checkPass;

    @NotEmpty(message = "请输入验证码")
    @Length(min = 4, max = 4, message = "验证码不正确")
    private String name;
}
