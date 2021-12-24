package com.mathflat.error.message;

import lombok.Getter;

@Getter
public enum UserExceptionMessage implements BaseExceptionMessage {
    USER_DUPLICATED("USER_DUPLICATED", "중복된 유저입니다.");;

    String code;
    String message;

    UserExceptionMessage(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
