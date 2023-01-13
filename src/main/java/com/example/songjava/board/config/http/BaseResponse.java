package com.example.songjava.board.config.http;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class BaseResponse<T> {
    private BaseResponseCode code;
    private String message;
    private T data;

    public BaseResponse(T data) {
        this.code = BaseResponseCode.SUCCESS;
        this.data = data;
    }

    public BaseResponse(BaseResponseCode code, String message) {
        this.code = code;
        this.message = message;
    }
}
