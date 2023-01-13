package com.example.songjava.board.config.exception;

import com.example.songjava.board.config.http.BaseResponseCode;

public class AbstractBaseException extends RuntimeException{
    private static final long serialVersionUID = 8342235231880246631L;

    //만들어둔 예외 코드사용을 위해 선언
    protected BaseResponseCode responseCode;

    //message 에 사용할 매개변수를 담을 배열 선언
    protected Object[] args;

    public AbstractBaseException() {
    }

    public AbstractBaseException(BaseResponseCode responseCode) {
        this.responseCode = responseCode;
    }

    public BaseResponseCode getResponseCode() {
        return responseCode;
    }

    public Object[] getArgs() {
        return args;
    }

}
