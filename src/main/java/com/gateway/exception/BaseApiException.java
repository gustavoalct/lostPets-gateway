package com.gateway.exception;

import org.apache.http.HttpStatus;

public class BaseApiException extends Throwable {
    HttpStatus statusCode;
    public BaseApiException(String message, HttpStatus statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }
}
