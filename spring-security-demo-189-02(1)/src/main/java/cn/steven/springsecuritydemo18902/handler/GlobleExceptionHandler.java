package cn.steven.springsecuritydemo18902.handler;

import cn.steven.springsecuritydemo18902.entity.Result;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.LockedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobleExceptionHandler {

    @ExceptionHandler(InternalAuthenticationServiceException.class)
    public Result handleLockedException(Throwable throwable){
        Result result = new Result();
        result.setCode(40030);
        result.setMsg(throwable.getMessage());
        System.out.println("异常捕获");
        return result;
    }

    @ExceptionHandler(LockedException.class)
    public Result handleLockedException2(Throwable throwable){
        Result result = new Result();
        result.setCode(40030);
        result.setMsg(throwable.getMessage());
        System.out.println("异常捕获");
        return result;
    }
}
