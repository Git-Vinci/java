package cn.steven.springboot189demo02.entity;

import cn.steven.springboot189demo02.exception.MyBindException;
import lombok.Data;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Teacher {
    @NotNull(message = "tid不能为空")
    private int tid;

    @NotBlank(message = "name不能为空")
    private String name;

    public void validate(BindingResult bindingResult){
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        StringBuilder stringBuilder = new StringBuilder();
        if(allErrors==null  || allErrors.size()==0) return;
        for(ObjectError error : allErrors){
            stringBuilder.append(error.getDefaultMessage());
        }

        //手动抛出异常
        throw  new MyBindException(stringBuilder.toString());

    }
}
