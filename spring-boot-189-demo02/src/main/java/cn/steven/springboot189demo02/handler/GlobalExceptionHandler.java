package cn.steven.springboot189demo02.handler;

import cn.steven.springboot189demo02.entity.ValidateResult;
import cn.steven.springboot189demo02.exception.MyBindException;
import org.springframework.util.Assert;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MyBindException.class)
    public ValidateResult handleBindException2(MyBindException e) {
        String message = e.getMessage();
        ValidateResult resultSet = new ValidateResult();
        resultSet.setCode(500);
        resultSet.setMessage(message);
        return  resultSet;
    }

    @ExceptionHandler(BindException.class)
    public List<ValidateResult> handleBindException(BindException e) {
        List<ObjectError> allErrors = e.getAllErrors();
        Assert.notNull(allErrors, "断言失败");//不这么写没问题的，if判断干到底
        List<ValidateResult> results = new ArrayList<>();

        for (ObjectError error : allErrors) {
            ValidateResult validateResult = new ValidateResult();
            validateResult.setCode(500);
            validateResult.setMessage(error.getDefaultMessage());
            results.add(validateResult);
        }

        return results;
    }
}
