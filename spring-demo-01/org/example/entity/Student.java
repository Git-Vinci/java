package org.example.entity;

public class Student {
    private int sid;
    private String name;

    public Student(int sid, String name) {
        this.sid = sid;
        this.name = name;
    }

    public Student() {
    }
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                '}';
    }
}
