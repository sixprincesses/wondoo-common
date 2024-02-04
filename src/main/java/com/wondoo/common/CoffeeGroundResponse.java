package com.wondoo.common;

public class CoffeeGroundResponse<T> {
    private T value;
    private Exception exception;

    private CoffeeGroundResponse(T newValue) {
        value = newValue;
    }

    private CoffeeGroundResponse(Exception newException) {
        exception = newException;
    }

    public static <T> CoffeeGroundResponse<T> ok(T value) {
        return new CoffeeGroundResponse<>(value);
    }

    public static <T> CoffeeGroundResponse<T> failed(Exception e) {
        return new CoffeeGroundResponse<>(e);
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
