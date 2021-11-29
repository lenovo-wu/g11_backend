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
@TableName("wall")
@NoArgsConstructor
@AllArgsConstructor
public class wall implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键 表白墙id
     */
    @TableId(value = "wall_id",type = IdType.AUTO)
    private int WallId;

    /**
     * 表白墙正文
     */
    @TableField("wall_content")
    private String WallContent;

    /**
     * 表白墙标题
     */
    @TableField("wall_contenttitle")
    private String WallContenttitle;

    /**
     * 表白墙发布时间
     */
    @TableField(value = "wall_time", fill = FieldFill.INSERT)
    private Date WallTime;


    /**
     * 发表白墙的用户
     */
    @TableField("wall_userid")
    private String WallUserid;

   /**
     * 表白墙状态，1正常2精选3删除
     */
    @TableField("wall_state")
    private String WallState;

    /**
     * 表白墙点赞数
     */
    @TableField("wall_good")
    private int WallGood;

    /**
     * 表白墙收藏数
     */
    @TableField("wall_collection")
    private int WallCollection;

    /**
     * 表白墙评论数
     */
    @TableField("wall_talk")
    private int WallTalk;

    /**
     * 表白墙举报数
     */
    @TableField("wall_report")
    private int WallReport;

    /**
     * 被表白对象
     */
    @TableField("wall_to")
    private String WallTo;
}