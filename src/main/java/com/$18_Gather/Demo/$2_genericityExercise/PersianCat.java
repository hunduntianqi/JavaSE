package com.$18_Gather.Demo.$2_genericityExercise;

public class PersianCat extends Cat{
    public PersianCat() {
    }
    
    public PersianCat(String name, Integer age) {
        super(name, age);
    }
    
    @Override
    public void eat() {
        System.out.println("一只叫做%s的, %s岁的波斯猫, 正在吃小饼干".formatted(this.getName(), this.getAge()));
    }
}
