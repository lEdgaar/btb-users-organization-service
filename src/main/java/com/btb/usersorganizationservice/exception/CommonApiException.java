package com.btb.usersorganizationservice.exception;

import org.springframework.http.HttpStatus;

public class CommonApiException extends Exception {

    public final static String CODE_KEY_STRING = "code:";
    public final static String MESSAGE_KEY_STRING = "message:";
    public final static String KEY_STRING = "key:";

    private String message;

    private Integer code;

    private String key;

    private HttpStatus httpStatus;

    private String responseErrorBody;

    public CommonApiException(int code, String key, HttpStatus httpStatus, String message) {
        super(message);
        this.code = code;
        this.key = key;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public CommonApiException(ErrorCode errorCode, String message) {
        this(errorCode.getCode(), errorCode.getKey(), HttpStatus.INTERNAL_SERVER_ERROR, message);
    }

}
