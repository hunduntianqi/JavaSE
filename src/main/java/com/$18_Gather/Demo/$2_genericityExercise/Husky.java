package com.$18_Gather.Demo.$2_genericityExercise;

public class Husky extends Dog{
    public Husky() {
    }
    
    public Husky(String name, Integer age) {
        super(name, age);
    }
    
    @Override
    public void eat() {
        System.out.println("一只叫做%s的, %s岁的哈士奇正在吃骨头, 边吃边拆家".formatted(this.getName(),
                this.getAge()));
    }
}
