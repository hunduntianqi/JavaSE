package com.$18_Gather.Demo.$2_genericityExercise;

public abstract class Dog extends Animal{
    public Dog() {
    }
    
    public Dog(String name, Integer age) {
        super(name, age);
    }
    
    public abstract void eat();
}
