package com.btb.usersorganizationservice.exception;

public class BrokerException extends CommonApiException {

    public BrokerException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

}
