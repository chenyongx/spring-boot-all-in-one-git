package com.jack.redis.lock.aop.exception;


public class LockException extends AbstractErrorException {
    private static final Integer HTTP_CODE = 409;
    private static final String ERROR_TYPE = "Lock";

    public LockException(ErrorResource resource) {
        super(ERROR_TYPE,resource);
    }

    public LockException(ErrorResource resource, ErrorReason reason) {
        super(ERROR_TYPE,resource,reason);
    }

    public LockException(String message){super(message);}

    @Override
    public Integer getHttpCode() {
        return HTTP_CODE;
    }
}
