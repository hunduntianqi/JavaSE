package com.$25_Reflection.$4_GetMethod;

import java.io.IOException;

public class Student {
    private int age;
    private String name;

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

    public void sleep () {
        System.out.println("睡觉");
    }

    private String eat (String something) throws IOException, NullPointerException, ClassCastException {
        System.out.println("在吃" + something);
        return "奥利给";
    }
}
