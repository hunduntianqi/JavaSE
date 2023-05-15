package com.$18_Gather.Demo.$2_genericityExercise;

public class Teddy extends Dog{
    public Teddy() {
    }
    
    public Teddy(String name, Integer age) {
        super(name, age);
    }
    
    @Override
    public void eat() {
        System.out.println("一只叫做%s的, %s岁的泰迪正在吃骨头, 边吃边蹭".formatted(this.getName(),
                this.getAge()));
    }
}
