package com.$18_Gather.Demo.$4_MapGatherDemo.$2_TreeMapExercise.$2;

import java.util.Objects;

public class Student implements Comparable<Student>{
    private String name;
    private Integer age = 0;
    
    public Student() {
    }
    
    public Student(String name, Integer age) {
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
        if (!(o instanceof Student student)) return false;
        return Objects.equals(name, student.name) && Objects.equals(age, student.age);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
    
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    
    @Override
    public int compareTo(Student o) {
        // 自定义比较规则
        // 按照年龄升序排序
        int temp = this.age - o.age;
        // 年龄一样按照姓名字母排序
        temp = temp == 0 ? o.name.compareTo(this.name) : temp;
        return temp;
    }
}
