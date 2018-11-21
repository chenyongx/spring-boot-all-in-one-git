package com.jack.redis.lock.aop.exception;

/**
 * 错误理由
 *
 */
public enum ErrorReason {

    //不能为空
    EMPTY("Empty"),

    //长度不服
    LENGTH("Length"),

    //格式不对
    FORMAT("Format"),

    //输入不合法
    INVALID_CHARS("InvalidChars"),

    //超出范围
    RANGE("Range"),

    //政策策略问题
    POLICY("Policy"),

	NOTEXIST("NotExist"),

    /**状态错误*/
    STATUS("Status"),

	/**没有找到*/
	NOT_FOUND("NotFound"),

	/**已经存在*/
    ALREADY_EXIST("AlreadyExist"),
    /**重复*/
    REPEAT("Repeat");

    private String value;

    ErrorReason(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
