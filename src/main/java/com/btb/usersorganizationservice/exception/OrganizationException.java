package com.btb.usersorganizationservice.exception;

public class OrganizationException extends CommonApiException {

    public OrganizationException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

}
