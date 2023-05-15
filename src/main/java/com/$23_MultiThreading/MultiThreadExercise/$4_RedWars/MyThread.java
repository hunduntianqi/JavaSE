package com.$23_MultiThreading.MultiThreadExercise.$4_RedWars;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread {
    // 定义静态变量, 记录红包个数
    public static int count = 3;
    // 定义静态变量, 记录红包数值
    public static double redMoney = 100.0;
    // 定义静态变量, 记录最小中奖金额
    public final static double MIN = 0.01;
    // 创建锁对象, 保护共享数据
    static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        // 上锁
        lock.lock();
        if (MyThread.count == 0) {
            System.out.println(Thread.currentThread().getName() + "没有抢到红包！！");
        } else {
            if (MyThread.count == 1) {
                // 表示是最后一个红包, 不需要再随机红包数值
                System.out.println(Thread.currentThread().getName() + "抢到了%.2f".formatted(MyThread.redMoney) + "元");
                // 抢走一个红包, 红包个数减一
                count--;
            } else {
                // 不是最后一个红包, 需要在红包剩余数值基础上进行随机获取红包数值
                try {
                    double red = new Random().nextDouble(MyThread.MIN, redMoney - (MyThread.count - 1) * MIN);
                    if (red < MIN) {
                        red = MIN;
                    }
                    System.out.println(Thread.currentThread().getName() + "抢到了%.2f".formatted(red) + "元");
                    // 剩余红包数值减去已经被抢走的红包数值
                    MyThread.redMoney -= red;
                    // 抢走一个红包, 红包个数减一
                    count--;
                } catch (Exception e) {
                    double red = MyThread.MIN;
                    System.out.println(Thread.currentThread().getName() + "抢到了%.2f".formatted(red) + "元");
                    // 剩余红包数值减去已经被抢走的红包数值
                    MyThread.redMoney -= red;
                    // 抢走一个红包, 红包个数减一
                    count--;
                }
            }
        }
        // 释放锁
        lock.unlock();
    }
}
