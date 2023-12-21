package com.btb.usersorganizationservice.exception;

public enum OrganizationErrorCode implements ErrorCode {
    ORGANIZATION_ID_NOT_NULL(1, "organization.id.not.null"),
    ORGANIZATION_NOT_FOUND(2, "organization.not.found");

    private final int code;

    private final String key;

    OrganizationErrorCode(int code, String key) {
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
