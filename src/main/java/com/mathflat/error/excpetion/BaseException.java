package com.mathflat.error.excpetion;

import com.mathflat.error.message.BaseExceptionMessage;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {
    BaseExceptionMessage baseExceptionMessage;

    public BaseException(BaseExceptionMessage baseExceptionMessage) {
        super(baseExceptionMessage.getMessage());
        this.baseExceptionMessage = baseExceptionMessage;
    }
}
