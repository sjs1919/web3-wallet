package com.sjs.wallet.common.exception;

import com.sjs.wallet.common.errcode.ErrorCode;
import com.sjs.wallet.common.result.Result;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器：统一捕获业务异常 / 参数校验异常 / 未预期异常。
 * Controller 层不手写 try-catch，交给本类兜底。
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public Result<Void> handleBusiness(BusinessException e) {
        return Result.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<Void> handleValidation(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getFieldError() != null
                ? e.getBindingResult().getFieldError().getDefaultMessage()
                : "参数错误";
        return Result.error(ErrorCode.PARAM_ERROR, message);
    }

    @ExceptionHandler(Exception.class)
    public Result<Void> handleUnexpected(Exception e) {
        return Result.error(ErrorCode.SYSTEM_ERROR, "系统繁忙，请稍后重试");
    }
}
