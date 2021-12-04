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
@TableName("choose")
@NoArgsConstructor
@AllArgsConstructor
public class choose implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键 认领id
     */
    @TableId(value = "choose_id",type = IdType.AUTO)
    private int chooseId;

    /**
     * 表白墙id
     */
    @TableField("choose_wallid")
    private String chooseWallid;

    /**
     * 被认领人id
     */
    @TableField("choose_beuserid")
    private String chooseBeuserid;

    /**
     * 认领人id
     */
    @TableField("choose_userid")
    private String chooseUserid;


    /**
     * 认领状态
     */
    @TableField("choose_state")
    private String chooseState;


    /**
     * 认领时间
     */
    @TableField(value = "choose_time", fill = FieldFill.INSERT)
    private Date chooseTime;

}