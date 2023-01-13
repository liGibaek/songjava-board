package com.example.songjava.board.config.exception;

import com.example.songjava.board.config.http.BaseResponseCode;

public class BaseException extends AbstractBaseException {
    private static final long serialVersionUID = 8342235231880246631L;

    public BaseException() {
    }

    public BaseException(BaseResponseCode responseCode) {
        this.responseCode = responseCode;
    }

    public BaseException(BaseResponseCode responseCode, String[] args) {
        this.args = args;
        this.responseCode = responseCode;
    }
}
