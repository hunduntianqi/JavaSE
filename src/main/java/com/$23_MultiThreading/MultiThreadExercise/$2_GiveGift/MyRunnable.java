package com.$23_MultiThreading.MultiThreadExercise.$2_GiveGift;

// 定义MyRunnable类, 实现Runnable接口
public class MyRunnable implements Runnable {
    // 定义变量, 记录剩余礼品数量
    private int count = 100;

    @Override
    public void run() {
        while (true) {
            // 使用同步代码块, 避免数据同步问题
            synchronized (MyRunnable.class) {
                // 1. 判断礼品数量是否小于10份
                if (this.count < 10) {
                    // 礼品数量小于10份, 结束循环
                    System.out.println("剩余礼品不足10份, 停止赠送！！");
                    break;
                } else {
                    // 礼品数不小于10份, 继续送礼
                    // 送出一份礼物, 礼品数减一
                    this.count--;
                    System.out.println(Thread.currentThread().getName() + "送出了一份礼品, 剩余礼品数量为: " + this.count);
                    try{
                        Thread.sleep(10);
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
