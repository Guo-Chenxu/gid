package com.guochenxu.gid.dto.req;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 新建tag参数
 *
 * @author: 郭晨旭
 * @create: 2024-01-06 16:49
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTagReq implements Serializable {

    private static final long serialVersionUID = 0L;

    @NotNull
    private String tag;

    /**
     * 每个号段起始id
     */
    @NotNull
    private Long startId;

    /**
     * 号段的步长
     */
    @NotNull
    private Long step;

    private String comment;
}
