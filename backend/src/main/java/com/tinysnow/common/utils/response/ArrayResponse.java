package com.tinysnow.common.utils.response;

import java.util.List;

import com.tinysnow.common.constant.DatabaseOperationResult;

import lombok.Data;

@SuppressWarnings("rawtypes")
@Data
public class ArrayResponse<T> extends Response<ArrayResponse> {

    /**
     * 数据集合
     */
    private List<T> data;

    /**
     * 总数，分页查询时的总条数
     */
    private Long total;

    public static <T> ArrayResponse<T> ok(List<T> data) {
        return ok(data, null, null);
    }

    public static <T> ArrayResponse<T> ok(List<T> data, Long total) {
        return ok(data, total, null);
    }

    public static <T> ArrayResponse<T> ok(List<T> data, String message) {
        return ok(data, null, message);
    }

    /**
     * 响应成功的返回
     * 
     * @param <T>
     * @param rows    原始数据
     * @param total   条数
     * @param message 附加消息
     * @return
     */
    public static <T> ArrayResponse<T> ok(List<T> rows, Long total, String message) {
        ArrayResponse<T> response = new ArrayResponse<>();
        response.setSuccess(true);
        response.setOperation(DatabaseOperationResult.SUCCESS);
        response.setMessage(message);
        response.setData(rows);
        response.setTotal(total);
        return response;
    }
}
