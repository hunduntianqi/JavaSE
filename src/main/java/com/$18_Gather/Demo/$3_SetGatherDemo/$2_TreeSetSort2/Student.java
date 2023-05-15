package com.$18_Gather.Demo.$3_SetGatherDemo.$2_TreeSetSort2;
/*
    TreeSet自定义排序方式二:
        TreeSet集合有参构造器, 可以设置Comparator接口对应的比较器对象, 来定制比较规则
 */

public class Student {
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
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
