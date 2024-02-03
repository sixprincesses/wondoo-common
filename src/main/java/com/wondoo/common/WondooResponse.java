package com.wondoo.common;

public class WondooResponse<T> {
    private T value;
    private Exception exception;

    private WondooResponse(T newValue) {
        value = newValue;
    }

    private WondooResponse(Exception newException) {
        exception = newException;
    }

    public static <T> WondooResponse<T> ok(T value) {
        return new WondooResponse<>(value);
    }

    public static <T> WondooResponse<T> failed(Exception e) {
        return new WondooResponse<>(e);
    }

    public T getOfDefault(T defaultValue) {
        return value != null ? value : defaultValue;
    }

    public boolean isSuccess() {
        return !hasException();
    }

    public boolean hasException() {
        return exception != null;
    }

    public T getValue() {
        return value;
    }

    public Exception getException() {
        return exception;
    }
}
