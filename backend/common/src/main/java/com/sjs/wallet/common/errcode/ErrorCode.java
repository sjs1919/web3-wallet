package com.sjs.wallet.common.errcode;

/**
 * 统一错误码表（5 位 = 3 位 HTTP 状态码 + 2 位业务细分码）。
 * 新增业务错误码必须先更新本类，再引用使用；禁止在代码中硬编码错误码。
 */
public final class ErrorCode {

    private ErrorCode() {
    }

    public static final int SUCCESS = 0;
    public static final int PARAM_ERROR = 40001;
    public static final int UNAUTHORIZED = 40101;
    public static final int FORBIDDEN = 40301;
    public static final int NOT_FOUND = 40401;
    public static final int SYSTEM_ERROR = 50001;
}
