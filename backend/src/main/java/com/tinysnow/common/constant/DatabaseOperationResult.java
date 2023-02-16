package com.tinysnow.common.constant;

import lombok.Data;

@Data
public class DatabaseOperationResult {

    public static final String SUCCESS = "success";

    public static final String FAILURE = "failure";

    public static final String UNKNOWN = "unknown error";

    public static final String SAVE_FAILURE = "save failed";

    public static final String UPDATE_FAILURE = "update failed";

    public static final String DELETE_FAILURE = "delete failed";
}
