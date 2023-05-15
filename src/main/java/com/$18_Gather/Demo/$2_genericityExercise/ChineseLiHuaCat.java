package com.$18_Gather.Demo.$2_genericityExercise;

public class ChineseLiHuaCat extends Cat{
    public ChineseLiHuaCat() {
    }
    
    public ChineseLiHuaCat(String name, Integer age) {
        super(name, age);
    }
    
    @Override
    public void eat() {
        System.out.println("一只叫做%s的, %s岁的狸花猫, 正在吃鱼".formatted(this.getName(), this.getAge()));
    }
}
