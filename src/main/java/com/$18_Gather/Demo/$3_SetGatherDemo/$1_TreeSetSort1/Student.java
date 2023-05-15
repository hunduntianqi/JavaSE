package com.$18_Gather.Demo.$3_SetGatherDemo.$1_TreeSetSort1;

/*
    TreeSet自定义排序方式一:
        让自定义的类实现Comparable接口重写里面的compareTo方法来定制比较规则
 */
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
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    
    // 自定义比较规则, 进行排序
    @Override
    public int compareTo(Student o) {
        // 指定排序规则, 按照年龄升序排序
        int ageGap = this.age - o.age;
        return ageGap;
    }
}
