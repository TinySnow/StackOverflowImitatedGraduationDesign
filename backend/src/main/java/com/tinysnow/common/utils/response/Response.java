package com.tinysnow.common.utils.response;

import lombok.Data;
import com.tinysnow.common.constant.DatabaseOperationResult;

@SuppressWarnings("rawtypes")
@Data
public class Response<T extends Response> {

    /**
     * 执行是否成功
     */
    protected boolean success;

    /**
     * 数据库操作执行结果
     */
    protected String operation;

    /**
     * 响应信息
     */
    protected String message;

    public boolean isSuccess() {
        return success;
    }

    public T operation(String operation) {
        this.operation = operation;
        return (T) this;
    }

    public T message(String message) {
        this.message = message;
        return (T) this;
    }

    public T success(boolean success) {
        this.success = success;
        return (T) this;
    }

    public static Response ok() {
        Response response = new Response();
        response.setSuccess(true);
        response.setOperation(DatabaseOperationResult.SUCCESS);
        return response;
    }

    public static Response error(String operation, String message) {
        Response<Response> response = new Response<>();
        response.setSuccess(false);
        response.setOperation(operation);
        response.setMessage(message);
        return response;
    }

    public static Response error(String message) {
        return error(DatabaseOperationResult.UNKNOWN, message);
    }

}
