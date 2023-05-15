package com.$23_MultiThreading.ThreadDemo.$7_WakeUpWaiting;

// 定义厨师类, 代表生产者, 继承Thread类
public class Cook_Producer extends Thread {
    @Override
    public void run() {
        /**
         * 1. 循环
         * 2. 编写同步代码块
         * 3. 判断共享数据是否到了末尾(先处理到了末尾的情况)
         * 4. 共享数据没有到末尾时, 要执行的核心逻辑
         */
        while (true) {
            synchronized (Desk_ControlData.lock) {
                if (Desk_ControlData.count == 0) {
                    break;
                } else {
                    if (Desk_ControlData.foodFlag == 1) {
                        // 桌子上有面条, 等待吃货吃面条
                        try {
                            Desk_ControlData.lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        // 桌子上没有面条, 开始做面条
                        System.out.printf("生产者: %s做了第%s碗面条\n", Thread.currentThread().getName(), (10 - Desk_ControlData.count) + 1);
                        // 修改桌子上食物的状态
                        Desk_ControlData.foodFlag = 1;
                        // 做好后唤醒吃货开始吃面条
                        Desk_ControlData.lock.notifyAll();
                    }
                }
            }
        }
    }
}
