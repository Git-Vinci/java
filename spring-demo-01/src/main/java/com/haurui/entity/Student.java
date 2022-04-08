package com.haurui.entity;

public class Student {

    private int sid;
    private String name;

    public Student() {
    }

    public Student(int sid, String name) {
        this.sid = sid;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                '}';
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
     //   System.out.println("setter方法执行");
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
      //  System.out.println("setter方法执行");
        this.name = name;
    }
}
