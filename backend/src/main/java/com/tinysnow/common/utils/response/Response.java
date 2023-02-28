package com.tinysnow.common.utils.response;

import java.util.HashMap;
import java.util.Objects;

import com.tinysnow.common.constant.HttpStatus;
import com.tinysnow.common.utils.strings.StringUtil;

public class Response extends HashMap<String, Object> {

    /**
     * 执行是否成功
     */
    private static final String SUCCESS_TAG = "success";

    /**
     * 状态码
     * 
     */
    private static final String CODE_TAG = "code";

    /**
     * 返回内容
     */
    private static final String MSG_TAG = "msg";

    /**
     * 数据对象
     */
    private static final String DATA_TAG = "data";

    /**
     * 初始化一个新创建的 Response 对象，使其表示一个空消息。
     */
    public Response() {
    }

    /**
     * 初始化一个新创建的 Response 对象
     * 
     * @param success 是否成功
     * @param code    状态码
     * @param msg     返回内容
     */
    public Response(boolean success, int code, String msg) {
        super.put(SUCCESS_TAG, success);
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }

    /**
     * 初始化一个新创建的 Response 对象
     * 
     * @param success 是否成功
     * @param code    状态码
     * @param msg     返回内容
     * @param data    数据对象
     */
    public Response(boolean success, int code, String msg, Object data) {
        super.put(SUCCESS_TAG, success);
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if (StringUtil.isNotNull(data)) {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 返回成功消息
     * 
     * @return 成功消息
     */
    public static Response success() {
        return Response.success("操作成功", null);
    }

    /**
     * 返回成功数据
     * 
     * @return 成功消息
     */
    public static Response success(Object data) {
        return Response.success("操作成功", data);
    }

    /**
     * 返回成功消息
     * 
     * @param msg 返回内容
     * @return 成功消息
     */
    public static Response success(String msg) {
        return Response.success(msg, null);
    }

    /**
     * 返回成功消息
     * 
     * @param msg  返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static Response success(String msg, Object data) {
        return new Response(true, HttpStatus.SUCCESS, msg, data);
    }

    /**
     * 返回警告消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static Response warn(String msg) {
        return Response.warn(msg, null);
    }

    /**
     * 返回警告消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static Response warn(String msg, Object data) {
        return new Response(true, HttpStatus.WARN, msg, data);
    }

    /**
     * 返回错误消息
     * 
     * @return 错误消息
     */
    public static Response error() {
        return Response.error("操作失败");
    }

    /**
     * 返回错误消息
     * 
     * @param msg 返回内容
     * @return 错误消息
     */
    public static Response error(String msg) {
        return Response.error(HttpStatus.ERROR, msg, null);
    }

    /**
     * 返回错误消息
     * 
     * @param msg  返回内容
     * @param data 数据对象
     * @return 错误消息
     */
    public static Response error(String msg, Object data) {
        return Response.error(HttpStatus.ERROR, msg, data);
    }

    /**
     * 返回错误消息
     * 
     * @param code 状态码
     * @param msg  返回内容
     * @return 错误消息
     */
    public static Response error(int code, String msg) {
        return Response.error(code, msg, null);
    }

    /**
     * 返回错误消息
     * 
     * @param code 状态码
     * @param msg  返回内容
     * @param data 返回数据
     * @return 错误消息
     */
    public static Response error(int code, String msg, Object data) {
        return new Response(false, code, msg, data);
    }

    /**
     * 是否为成功消息
     *
     * @return 结果
     */
    public boolean isSuccess() {
        return !isError();
    }

    /**
     * 是否为错误消息
     *
     * @return 结果
     */
    public boolean isError() {
        return Objects.equals(HttpStatus.ERROR, this.get(CODE_TAG));
    }

    /**
     * 方便链式调用
     *
     * @param key   键
     * @param value 值
     * @return 数据对象
     */
    @Override
    public Response put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
