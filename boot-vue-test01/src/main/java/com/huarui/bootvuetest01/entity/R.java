package com.huarui.bootvuetest01.entity;

public class R<T> {

    private int code;

    private String message;

    private T data;

    private R(Builder builder){
        this.code=builder.code;
        this.message=builder.message;
    }

    public static class Builder<T>{
        private int code;

        private String message;

        private T data;

        public Builder() {}

        public Builder(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public R buildOk(){
            Builder builder = new Builder(200, "正常响应");
            return new R(builder);
        }
        public R buildFail(){
            Builder builder = new Builder(500, "内部错误");
            return new R(builder);
        }
        public R buildCustomer(int code,String message){
            Builder builder = new Builder(code, message);
            return new R(builder);
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public R setData(T data) {
        this.data = data;
        return this;
    }
}
