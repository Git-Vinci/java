package com.haurui.entity;

public class StudentFactory {

    public static Student getStudent(){
        return new Student(1,"boone");
    }
}
