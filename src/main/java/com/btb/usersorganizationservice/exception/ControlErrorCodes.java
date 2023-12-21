package com.btb.usersorganizationservice.exception;

public enum ControlErrorCodes implements ErrorCode {
    DB(1, "database.error")
    ;

    private final int code;

    private final String key;

    ControlErrorCodes(int code, String key) {
        this.code = code;
        this.key = key;
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
