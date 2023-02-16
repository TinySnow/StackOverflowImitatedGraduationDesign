package com.tinysnow.common.utils.response;

import com.tinysnow.common.constant.DatabaseOperationResult;

import lombok.Data;

@SuppressWarnings("rawtypes")
@Data
public class ObjectResponse<T> extends Response<ObjectResponse> {
    /**
     * 单个数据对象
     */
    private T data;

    /**
     * 单数据对象响应成功的方法
     * 
     * @param <T>
     * @param data    数据对象
     * @param message 附加消息
     * @return
     */
    public static <T> ObjectResponse<T> ok(T data, String message) {
        ObjectResponse<T> response = new ObjectResponse<>();
        response.setSuccess(true);
        response.setOperation(DatabaseOperationResult.SUCCESS);
        response.setMessage(message);
        response.setData(data);
        return response;
    }

    public static <T> ObjectResponse<T> ok(T data) {
        return ok(data, null);
    }
}
