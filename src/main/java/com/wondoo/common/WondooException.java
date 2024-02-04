package com.wondoo.common;

public class WondooException extends RuntimeException {
    private final int statusCode;
    private final String errorCode;
    private final String message;

    public WondooException(int statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
