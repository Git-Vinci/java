package cn.steven.springboot189demo02.exception;

public class BaseException extends  RuntimeException {
    private String message ;
    public BaseException(String message){
        this.message =message;
    }
}
