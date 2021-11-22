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
@TableName("reply")
@NoArgsConstructor
@AllArgsConstructor
public class reply implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键 回复id号
     */
    @TableId(value = "reply_id",type=IdType.AUTO)
    private Integer id;

    /**
     * 在哪个帖子下面回复
     */
    @TableField("wallid")
    private int Wallid;

    /**
     * 回复正文
     */
    @TableField("reply_content")
    private String ReplyContent;

    /**
     * 回复的用户id
     */
    @TableField("reply_userid")
    private String ReplyUserid;

    /**
     * 回复时间
     */
    @TableField(value = "reply_time", fill = FieldFill.INSERT)
    private Date ReplyTime;

    /**
     * 回复状态，1为正常2为删除
     */
    @TableField("reply_state")
    private int ReplyState;
}