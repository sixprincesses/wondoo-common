package com.wondoo.common;

public class InternalServerException extends WondooException {
    public InternalServerException(int statusCode, String errorCode, String message) {
        super(statusCode, errorCode, message);
    }
}
