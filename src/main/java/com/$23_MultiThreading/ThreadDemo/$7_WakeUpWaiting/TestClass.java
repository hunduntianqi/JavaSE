package com.$23_MultiThreading.ThreadDemo.$7_WakeUpWaiting;

public class TestClass {
    // 测试类, 测试等待唤醒机制是否正常执行
    public static void main(String[] args) {
        // 创建吃货对象
        Foodie_Consumers foodie = new Foodie_Consumers();
        // 创建厨师对象
        Cook_Producer cook = new Cook_Producer();
        // 修改线程名称
        foodie.setName("吃货");
        cook.setName("厨师");
        // 启动线程
        foodie.start();
        cook.start();
    }
}
