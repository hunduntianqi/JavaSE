package com.$23_MultiThreading.ThreadDemo.$5_SyncMethod;

public class MyRunnableTest {
    public static void main(String[] args) throws Exception{
        long start = System.currentTimeMillis();
        // 创建MyRunnable对象
        MyRunnable myRunnable = new MyRunnable();
        // 创建三个Thread对象
        Thread thread1 = new Thread(myRunnable, "Windows One");
        Thread thread2 = new Thread(myRunnable, "Windows Two");
        Thread thread3 = new Thread(myRunnable, "Windows Three");
        // 启动三个子线程
        thread1.start();
        thread2.start();
        thread3.start();
        // 设置子线程插入主线程, 防止主线程瞬间执行完毕
        thread1.join();
        thread2.join();
        thread3.join();
        long end = System.currentTimeMillis();
        System.out.printf("程序共耗时 %s S", (end - start) / 1000.0);
    }
}
