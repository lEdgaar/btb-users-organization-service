package com.btb.usersorganizationservice.exception;

public enum RoleTypeErrorCode implements ErrorCode {
    ROLE_TYPE_INTERNAL_CODE_NOT_NULL(1, "role.type.internal.code.not.null"),
    ROLE_TYPE_NOT_FOUND(2, "role.type.not.found");

    private final int code;
    private final String message;

    RoleTypeErrorCode(int code, String message) {
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
