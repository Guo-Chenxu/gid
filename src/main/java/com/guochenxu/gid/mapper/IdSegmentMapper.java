package com.guochenxu.gid.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guochenxu.gid.entity.IdSegment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * (IdSegment)表数据库访问层
 *
 * @author: guochenxu
 * @create: 2024-01-06 16:11:27
 * @version: 1.0
 */
@Mapper
public interface IdSegmentMapper extends BaseMapper<IdSegment> {

    /**
     * 列出所有tag
     */
    @Select("select tag from id_segment")
    List<String> listTags();

    /**
     * 获取tag的下一个号段
     * 返回下个号段的起始id
     */
    @Update("update id_segment set start_id=start_id+step where tag = #{tag}")
    int updateTag(@Param("tag") String tag);

    /**
     * 通过tag获取下一个号段的起始id
     */
    @Select("select start_id, step from id_segment where tag = #{tag}")
    IdSegment getStartIdByTag(@Param("tag") String tag);
}

