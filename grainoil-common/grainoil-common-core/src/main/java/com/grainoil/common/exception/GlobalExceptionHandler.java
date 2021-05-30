package com.grainoil.common.exception;

import com.grainoil.common.core.domain.R;
import com.grainoil.common.core.domain.ResponseResult;
import com.grainoil.common.enums.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 * @author zmr
 * @author lucas
 */
@RestControllerAdvice
public class GlobalExceptionHandler
{
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 请求方式不支持
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
    public ResponseResult handleException(HttpRequestMethodNotSupportedException e)
    {
        logger.error(e.getMessage(), e);
        return ResponseResult.error("不支持' " + e.getMethod() + "'请求");
    }

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseResult notFount(RuntimeException e)
    {
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
        {
            throw e;
        }
        logger.error("运行时异常:", e);
        return ResponseResult.error("运行时异常:" + e.getMessage());
    }

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(GrainOilException.class)
    public ResponseResult handleWindException(GrainOilException e)
    {
        return ResponseResult.error(e.getMessage());
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseResult handleDuplicateKeyException(DuplicateKeyException e)
    {
        logger.error(e.getMessage(), e);
        return ResponseResult.error("数据库中已存在该记录");
    }

    @ExceptionHandler(Exception.class)
    public ResponseResult handleException(Exception e)
    {
        logger.error(e.getMessage(), e);
        return ResponseResult.error(e.getMessage());
    }

    /**
     * 捕获并处理未授权异常
     *
     * @param e 授权异常
     * @return 统一封装的结果类, 含有代码code和提示信息msg
     */
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseResult handle401(UnauthorizedException e)
    {
        return ResponseResult.result(ResultCode.UNAUTHORIZED);
    }

    // 验证码错误
    @ExceptionHandler(ValidateCodeException.class)
    public ResponseResult handleCaptcha(ValidateCodeException e)
    {
        return ResponseResult.error(e.getMessage());
    }
}