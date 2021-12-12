package com.g11zucc.g11_back.model.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Builder
@Accessors(chain = true)
@TableName("email")
@NoArgsConstructor
@AllArgsConstructor
public class email {
    private static final long serialVersionUID = 1L;

    /**
     * email
     */
    @TableField("email")
    private String email;
    /**
     * code
     */
    @TableField("code")
    private int code;
}

