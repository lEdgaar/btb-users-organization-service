package com.btb.usersorganizationservice.exception;

public class RoleTypeException extends CommonApiException {

    public RoleTypeException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

}
