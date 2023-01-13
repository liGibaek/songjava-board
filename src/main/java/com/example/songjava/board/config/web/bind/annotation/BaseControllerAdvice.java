package com.example.songjava.board.config.web.bind.annotation;

import com.example.songjava.board.config.exception.BaseException;
import com.example.songjava.board.config.http.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Locale;

@ControllerAdvice
@RequiredArgsConstructor
public class BaseControllerAdvice {

    private final MessageSource messageSource;


    @ExceptionHandler(value = { BaseException.class })
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    private BaseResponse<?> handlerBaseException(BaseException e, WebRequest request){
        return new BaseResponse<>(e.getResponseCode(), messageSource.getMessage(e.getResponseCode().name(),e.getArgs(), Locale.getDefault()));
    }


}
