package com.guochenxu.gid.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 获取id返回值
 *
 * @author: 郭晨旭
 * @create: 2024-01-06 16:54
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetIdResp implements Serializable {
    private static final long serialVersionUID = 1L;

    private String tag;
    private Long id;
}
