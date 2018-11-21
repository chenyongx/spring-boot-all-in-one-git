package com.jack.redis.lock.aop.exception;

import com.netflix.hystrix.exception.HystrixBadRequestException;

/**
 * 异常基类
 *
 */
public abstract class AbstractErrorException extends HystrixBadRequestException {

    public AbstractErrorException(String errorCode, ErrorResource resource) {
        super(String.format("%s.%s",errorCode,resource.getValue()));
    }

    public AbstractErrorException(String errorCode, ErrorResource resource, ErrorReason reason) {
        super(String.format("%s.%s.%s",errorCode,resource.getValue(),reason.getValue()));
    }

    public AbstractErrorException(String message) {
        super(message);
    }

    public abstract Integer getHttpCode();
}
