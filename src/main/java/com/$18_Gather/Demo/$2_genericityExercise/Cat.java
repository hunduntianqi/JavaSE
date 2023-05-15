package com.$18_Gather.Demo.$2_genericityExercise;

public abstract class Cat extends Animal{
    public Cat() {
    }
    
    public Cat(String name, Integer age) {
        super(name, age);
    }
    
    public abstract void eat();
}
