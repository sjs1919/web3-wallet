package com.sjs.wallet.common.result;

import com.sjs.wallet.common.errcode.ErrorCode;

/**
 * 统一 API 响应体。
 *
 * @param code    错误码（0 成功，其余见 {@code com.sjs.wallet.common.errcode.ErrorCode}）
 * @param message 提示信息（成功为 success，失败为中文错误描述）
 * @param data    业务数据，失败时为 null
 */
public record Result<T>(int code, String message, T data) {

    public static <T> Result<T> success(T data) {
        return new Result<>(ErrorCode.SUCCESS, "success", data);
    }

    public static Result<Void> success() {
        return new Result<>(ErrorCode.SUCCESS, "success", null);
    }

    public static <T> Result<T> error(int code, String message) {
        return new Result<>(code, message, null);
    }
}
