package com.mathflat.error;

import com.mathflat.response.BaseExceptionMessage;
import lombok.Getter;

public class DuplicatedIdException extends RuntimeException {
    @Getter
    private final BaseExceptionMessage baseExceptionMessage;

    public DuplicatedIdException(BaseExceptionMessage baseExceptionMessage) {
        this.baseExceptionMessage = baseExceptionMessage;
    }
}
