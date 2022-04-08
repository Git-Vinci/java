package cn.steven.springboot189demo02.exception;

public class MyBindException extends  BaseException {

  private String message ;
    public MyBindException(String message) {
        super(message);
        this.message =message;
    }

    public String getMessage(){
        return  message;
    }


}
