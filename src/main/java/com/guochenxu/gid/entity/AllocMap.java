package com.guochenxu.gid.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 分配池
 *
 * @author: 郭晨旭
 * @create: 2024-01-06 17:19
 * @version: 1.0
 */
public class AllocMap {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Alloc {
        private String tag;
        private List<IdSeg> idSegs;
        /**
         * 当前是否在查询数据库
         */
        private boolean getDB = false;

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class IdSeg {
        /**
         * 当前发了多少号
         */
        private long cur;
        private long start;
        private long end;
    }


    private static final ConcurrentHashMap<String, Alloc> map = new ConcurrentHashMap<>();

    public static void addTag(String tag) {
        map.put(tag, new Alloc(tag, new ArrayList<>(2), false));
    }

    public static Alloc getByTag(String tag) {
        return map.get(tag);
    }

    private AllocMap() {

    }
}
