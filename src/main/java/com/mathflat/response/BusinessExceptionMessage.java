package com.mathflat.response;

public enum BusinessExceptionMessage implements BaseExceptionMessage {
    BAD_REQUEST("BAD_REQUEST_BODY", "처리할 수 없는 요청입니다."),
    STUDENT_NOT_FOUND("STUDENT_NOT_FOUND", "학생을 찾을 수 없습니다.")
    ;

    private final String code;
    private final String message;

    BusinessExceptionMessage(final String code, final String message) {
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
