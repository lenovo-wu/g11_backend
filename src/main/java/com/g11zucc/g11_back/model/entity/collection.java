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
@TableName("collection")
@NoArgsConstructor
@AllArgsConstructor
public class collection implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "collection_id",type=IdType.AUTO)
    private Integer id;

    /**
     * 收藏的用户id
     */
    @TableField("collection_userid")
    private String CollectionUserid;

    /**
     * 收藏的帖子id
     */
    @TableField("collection_wallid")
    private String CollectionWallid;

    /**
     * 收藏时间
     */
    @TableField(value = "collection_time", fill = FieldFill.INSERT)
    private Date collectionTime;


}