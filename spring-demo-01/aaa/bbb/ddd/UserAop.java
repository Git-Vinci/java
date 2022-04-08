package aaa.bbb.ddd;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Arrays;


@Aspect
public class UserAop {

    @Pointcut("execution(* aaa.bbb.ccc.User.*(..))")
    public void point(){}

    @AfterThrowing(value = "point()" , throwing = "e")
    public void exceptionHandle(Exception e){
        System.out.println("异常通知出发");
        e.printStackTrace();
    }
/*    @Around(value = "point()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("方法执行之前");
        System.out.println(Arrays.toString(joinPoint.getArgs()));
        Object proceed = joinPoint.proceed();
        System.out.println("方法执行之后");
        return proceed;
    }*/

/*    @Before(value = "point()")
    public void before(){
        System.out.println("aop的before方法执行");
    }

    @After(value = "point()")
    public void after(){
        System.out.println("aop的after方法执行");
    }*/
}
