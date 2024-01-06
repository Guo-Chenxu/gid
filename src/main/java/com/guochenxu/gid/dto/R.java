package com.guochenxu.gid.dto;

import com.guochenxu.gid.constants.HttpCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * 统一返回类
 *
 * @author: guochenxu
 * @create: 2023-10-25 11:23
 * @version: 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code;
    private String msg;
    private T data;

    public R<T> success() {
        return new R<>(HttpCode.SUCCESS, "执行成功", null);
    }

    public R<T> success(String _msg) {
        return new R<>(HttpCode.SUCCESS, _msg, null);
    }

    public R<T> success(T _data) {
        return new R<>(HttpCode.SUCCESS, "执行成功", _data);
    }

    public R<T> success(String _msg, T _data) {
        return new R<>(HttpCode.SUCCESS, _msg, _data);
    }

    public R<T> error(String _msg) {
        return new R<>(HttpCode.SERVER_WRONG, _msg, null);
    }

    public R<T> error(T _data) {
        return new R<>(HttpCode.SERVER_WRONG, "执行失败", _data);
    }

    public R<T> error(String _msg, T _data) {
        return new R<>(HttpCode.SERVER_WRONG, _msg, _data);
    }

    public R<T> error(Integer _code, String _msg) {
        return new R<>(_code, _msg, null);
    }
}
