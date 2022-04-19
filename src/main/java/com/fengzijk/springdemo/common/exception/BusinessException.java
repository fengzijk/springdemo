package com.fengzijk.springdemo.common.exception;

/**
 * -------------------------------------------------
 * <pre>业务异常</pre>
 *
 * @author : fengzijk
 * @date : 2021/10/3 19:17
 * --------------------------------------------------
 */

public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 8928045291851849140L;
    private int code;

    public BusinessException() {
        super();
    }

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}