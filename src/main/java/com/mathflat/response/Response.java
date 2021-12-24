package com.mathflat.response;

import lombok.Getter;
import lombok.Value;

@Value
@Getter
public class Response<T> {
    private final T data;
    private final FieldError error;

    private Response() {
        this.data = null;
        this.error = null;
    }

    private Response(T data) {
        this.data = data;
        this.error = null;
    }

    private Response(String code, String message) {
        this.data = null;
        this.error = new FieldError(code, message);
    }

    public static <T> Response<T> createResponse() {
        return new Response();
    }

    public static <T> Response<T> createResponse(final T data) {
        return new Response(data);
    }

    public static <T> Response<T> createErrorResponse(final String code, final String message) {
        return new Response(code, message);
    }

    public static <T> Response<T> createErrorResponse(final String code, final String message, final String target) {
        return new Response(code, message + " [" + target + "]");
    }

    @Getter
    private static class FieldError {
        private final String code;
        private final String message;

        private FieldError(final String code, final String message) {
            this.code = code;
            this.message = message;
        }
    }
}
