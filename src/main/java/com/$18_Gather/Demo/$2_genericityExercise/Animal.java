package com.$18_Gather.Demo.$2_genericityExercise;

public abstract class Animal {
    private String name;
    private Integer age = 0;
    
    public Animal() {
    }
    
    public Animal(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    
    public abstract void eat();
    
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
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
