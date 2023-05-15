package com.$23_MultiThreading.ThreadDemo.$1_InheritThreadClass;


// 定义测试类, 测试多线程执行情况
public class TestMyThread {
    public static void main(String[] args) {
        // 创建MyThread类对象
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        // 调用run()方法
        // myThread.run();
        // 调用start()方法
         myThread1.start();
         myThread2.start();
    }
}
