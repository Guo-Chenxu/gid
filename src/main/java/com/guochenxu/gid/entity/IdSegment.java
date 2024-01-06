package com.guochenxu.gid.entity;


import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Indexed;


/**
 * (IdSegment)表实体类
 *
 * @author: guochenxu
 * @create: 2024-01-06 16:11:27
 * @version: 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IdSegment implements Serializable {

    private static final long serialVersionUID = 0L;

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String tag;

    /**
     * 每个号段起始id
     */
    private Long startId;

    /**
     * 号段的步长
     */
    private Long step;

    private String comment;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}

