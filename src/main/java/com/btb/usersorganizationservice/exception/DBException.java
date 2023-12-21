package com.btb.usersorganizationservice.exception;

import org.springframework.http.HttpStatus;

public class DBException extends CommonApiException {


    public DBException(String message) {
        super(ControlErrorCodes.DB, message);
    }
}
