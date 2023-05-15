package com.$23_MultiThreading.MultiThreadExercise.$1_SellMoiveTicket;

// 定义MyRunnable类, 实现Runnable接口
public class MyRunnable implements Runnable {
    // 定义变量, 记录剩余票数
    private int count = 1000;

    @Override
    public void run() {
        while (true) {
            // 使用同步代码块, 避免数据同步问题
            synchronized (MyRunnable.class) {
                // 1. 判断票数是否为0
                if (this.count == 0) {
                    // 票数为零, 结束循环
                    System.out.println("剩余票数为0, 电影票已售罄！！");
                    break;
                } else {
                    // 票数不为零, 继续卖票
                    // 卖出一张票, 票数减一
                    this.count--;
                    System.out.println(Thread.currentThread().getName() + "卖出了一张票, 剩余票数为 " + this.count);
                    // 卖出一张票, 等待三秒钟
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
