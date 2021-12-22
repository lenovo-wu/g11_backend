package com.g11zucc.g11_back.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class EmailDTO {
    private String stunum;
    private int code;
    private String pass;
    private String checkPass;
    private String othername;
    private String sex;
    private String name;
}
