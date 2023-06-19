package com.example.studentmanagementportal;

public class Teacher {
    private String name;
    private int teacherId;
    private String subject;
    private int age;

    public Teacher() {
    }

    public Teacher(String name, int teacherId, String subject, int age) {
        this.name = name;
        this.teacherId = teacherId;
        this.subject = subject;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", teacherId=" + teacherId +
                ", subject='" + subject + '\'' +
                ", age=" + age +
                '}';
    }
}
