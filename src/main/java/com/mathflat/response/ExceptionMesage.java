package com.mathflat.response;

public enum ExceptionMesage {
    STUDENT_NOT_FOUND("STUDENT_NOT_FOUND", "학생을 찾을 수 없습니다."),
    BAD_REQUEST("BAD_REQUEST", "올바르지 못한 요청")
;
    private final String code;
    private final String message;

    ExceptionMesage(final String code, final String message) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return code;
    }
}
