package cn.steven.springboot189demo02.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

// hibernate 校验框架
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class Student {

     @NotNull(message="sid不能为空")
     private Integer sid;

     @NotBlank(message = "name不能为空")
     private String name;

    @Range(min = 0,max = 180,message = "age不合法")
     private Integer age;

     @Email(message = "email不合法")
     private String email;

     @NotEmpty(message = "hobbies不能为空")
     private List<String> hobbies;

}
