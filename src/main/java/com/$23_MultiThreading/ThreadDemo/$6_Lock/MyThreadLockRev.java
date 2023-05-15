package com.$23_MultiThreading.ThreadDemo.$6_Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThreadLockRev extends Thread {
    // 定义静态变量, 记录卖出的票数
    static int ticket = 0;

    // 创建Lock对象
    static Lock lock = new ReentrantLock();

    // 重写run()方法
    @Override
    public void run() {
        while (true) {
            // 加锁
            lock.lock();
            // 判断票是否已卖完
            try {
                if (ticket == 100) {
                    lock.unlock();
                    break;
                } else {
                    ticket++;
                    System.out.printf("%s 售出第 %s 张票\n", Thread.currentThread().getName(), ticket);
                    Thread.sleep(10);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 释放锁
                lock.unlock();
            }

        }
    }
}
