package com.$22_FileAndIOStream.$6_SerializeStreamDemo;

/*
    javabean 类, 用于创建对象
 */

import java.io.Serializable;

public class JavaBeanStudent implements Serializable {
    private String name;
    private int age;
    private String address;

    public JavaBeanStudent() {
    }

    public JavaBeanStudent(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "JavaBeanEmployee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
