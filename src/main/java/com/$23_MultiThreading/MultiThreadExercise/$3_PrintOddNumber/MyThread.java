package com.$23_MultiThreading.MultiThreadExercise.$3_PrintOddNumber;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread {
    // 定义静态变量, 记录0-100之间的数字
    public static int number = 0;
    // 创建锁对象, 用来保证数据安全
    public static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        // 循环
        while (MyThread.number < 100) {
            // 上锁
            lock.lock();
            // 判断number是否为奇数
            if (MyThread.number % 2 != 0) {
                // number是奇数, 打印线程名和number
                System.out.println(Thread.currentThread().getName() + " 打印了奇数 " + MyThread.number);
            }
            MyThread.number++;
            lock.unlock();
        }
    }
}
