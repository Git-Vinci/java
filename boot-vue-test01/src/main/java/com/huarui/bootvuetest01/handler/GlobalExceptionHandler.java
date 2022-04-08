package com.huarui.bootvuetest01.handler;

import com.huarui.bootvuetest01.entity.R;
import com.huarui.bootvuetest01.exception.ValidateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(ValidateException.class)
    public R handValidateException(Exception e, HttpServletRequest request){
          log.info("you have a exception in path {},message:{}",request.getRequestURI(),e.getMessage());
          return new R.Builder<String>().buildFail().setData(e.getMessage());
    }
}
