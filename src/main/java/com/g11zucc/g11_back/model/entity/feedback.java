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
@TableName("feedback")
@NoArgsConstructor
@AllArgsConstructor
public class feedback implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键 反馈id号
     */
    @TableId(value = "feedback_id",type=IdType.AUTO)
    private Integer FeedbackId;

    /**
     * 反馈标题
     */
    @TableField("feedback_title")
    private String FeedbackTitle;

    /**
     * 反馈正文
     */
    @TableField("feedback_content")
    private String FeedbackContent;

    /**
     * 反馈id
     */
    @TableField("feedback_userid")
    private String FeedbackUserid;

    /**
     * 反馈时间
     */
    @TableField(value = "feedback_date", fill = FieldFill.INSERT)
    private Date FeedbackTime;

    /**
     * 反馈状态，1为未处理，2为已经处理
     */
    @TableField("feedback_state")
    private String FeedbackState;
}