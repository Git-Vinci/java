package com.huarui.bootvuetest01.entity;

import com.huarui.bootvuetest01.exception.ValidateException;
import lombok.Data;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class Student {

    public void validate(BindingResult result){
        List<ObjectError> allErrors = result.getAllErrors();
        if(allErrors!=null && allErrors.size()>0){
            StringBuffer stringBuffer = new StringBuffer();
            for(ObjectError error :allErrors){
                stringBuffer.append(error.getDefaultMessage()+",");
            }
            throw  new ValidateException(stringBuffer.toString());
        }
    }

    @NotNull(message = "id不能为空")
    private Integer sid ;

    @NotEmpty(message = "name不能为空")
    private String name ;

    @NotEmpty(message = "email必须格式正确")
    private String email;
}
