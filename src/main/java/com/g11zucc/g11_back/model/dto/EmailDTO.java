package com.g11zucc.g11_back.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class EmailDTO {
    private String email;
    private int code;
}
