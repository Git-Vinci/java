package com.haurui.entity;

public class School {
    private Teacher teacher;
    private Student student;

    public School() {
       // System.out.println("school无参构造的执行...");
    }

    public School(Teacher teacher, Student student) {
        this.teacher = teacher;
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "School{" +
                "teacher=" + teacher +
                ", student=" + student +
                '}';
    }
}
