package com.mathflat.error.excpetion;

import com.mathflat.error.message.BaseExceptionMessage;

public class UserException extends BaseException {
    public UserException(BaseExceptionMessage baseExceptionMessage) {
        super(baseExceptionMessage);
    }
}
