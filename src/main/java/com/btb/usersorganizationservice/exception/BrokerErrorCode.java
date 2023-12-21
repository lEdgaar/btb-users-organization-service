package com.btb.usersorganizationservice.exception;

public enum BrokerErrorCode implements ErrorCode {
    USER_ID_NOT_NULL(1, "user.id.not.null"),
    USER_NOT_FOUND(2, "user.not.found"),
    EMAIL_NOT_NULL(3, "email.not.null"),
    NAME_OR_EMAIL_NOT_NULL(4, "name.or.email.not.null");

    private final int code;
    private final String message;

    BrokerErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return 0;
    }

    @Override
    public String getKey() {
        return null;
    }
}
