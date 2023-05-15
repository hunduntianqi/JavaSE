package com.$23_MultiThreading.MultiThreadExercise.$4_RedWars;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadTest {
    /*
        需求 ==> 抢红包
        假设: 100块, 分成三个包, 现在有5个人去抢
        其中红包是共享数据, 5个人是5条线程
        控制台打印结果如下:
            xxx抢到了xxx元
            xxx抢到了xxx元
            xxx抢到了xxx元
            xxx没抢到
            xxx没抢到
     */
    public static void main(String[] args) {
//        // 多线程抢红包测试类
//        // 创建5个线程对象
//        MyThread thread1 = new MyThread();
//        MyThread thread2 = new MyThread();
//        MyThread thread3 = new MyThread();
//        MyThread thread4 = new MyThread();
//        MyThread thread5 = new MyThread();
//        // 启动线程
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//        thread5.start();

         // 线程池实现
        ExecutorService pool = Executors.newFixedThreadPool(5);
        pool.submit(new MyThread());
        pool.submit(new MyThread());
        pool.submit(new MyThread());
        pool.submit(new MyThread());
        pool.submit(new MyThread());
        pool.shutdown();
    }
}
