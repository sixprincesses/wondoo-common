package com.wondoo.common;

public class BadRequestException extends WondooException {
    public BadRequestException(int statusCode, String errorCode, String message) {
        super(statusCode, errorCode, message);
    }
}
