package com.$23_MultiThreading.ThreadDemo.$1_InheritThreadClass;

// 定义线程类, 继承Thread类
public class MyThread extends Thread{
    // 重写run()方法, 封装要执行的代码
    public void run() {
        super.run();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            System.out.println("多线程测试程序, 循环执行%s次".formatted(i + 1));
        }
        long end = System.currentTimeMillis();
        System.out.println("程序执行时间为 %s s".formatted((end - start) / 1000.0));
    }
}
