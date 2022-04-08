package com.huarui.bootvuetest01.exception;

public class BaseException extends  RuntimeException {
    private String msg ;
    public  BaseException(String msg){
        super(msg);
        this.msg=msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
