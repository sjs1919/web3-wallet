package com.sjs.wallet.common.exception;

/**
 * 业务异常：Service 层抛出，由全局异常处理器统一转换为错误响应。
 * 所有业务错误必须携带错误码，禁止使用裸 RuntimeException 表达业务失败。
 */
public class BusinessException extends RuntimeException {

    private final int code;

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
