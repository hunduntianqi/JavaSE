package com.$25_Reflection.$1_GetClassObjectDemo;

public class Student {
    private String name;
    private int age;


    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Student() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
