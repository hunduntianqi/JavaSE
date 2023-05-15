package com.$18_Gather.Demo.$3_SetGatherDemo;

import java.util.Objects;

public class $2_Student {
    private String name;
    private Integer age = 0;
    
    public $2_Student() {
    }
    
    public $2_Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof $2_Student that)) return false;
        return Objects.equals(name, that.name) && Objects.equals(age, that.age);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
    
    @Override
    public String toString() {
        return "$2_Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
