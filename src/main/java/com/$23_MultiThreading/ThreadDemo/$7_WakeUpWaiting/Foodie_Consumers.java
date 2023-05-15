package com.$23_MultiThreading.ThreadDemo.$7_WakeUpWaiting;

// 定义吃货类, 代表消费者, 继承Thread
public class Foodie_Consumers extends Thread {

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
                    // 核心逻辑
                    // 1. 先判断桌子上是否有面条
                    // 2. 有面条 ==> 开吃; 没有面条 ==> 等待
                    // 3. 吃完面条后唤醒厨师继续做面条
                    // 4. 吃完一碗面条后, 将吃面条的总数减一
                    // 5. 修改桌子上食物的状态
                    if (Desk_ControlData.foodFlag == 1) {
                        // 桌子上有食物, 开吃
                        Desk_ControlData.count--;
                        System.out.printf("消费者: %s开始吃第%s碗面条\n", Thread.currentThread().getName(), 10 - Desk_ControlData.count);
                        Desk_ControlData.foodFlag = 0;
                        // 吃完后唤醒厨师继续做面条
                        Desk_ControlData.lock.notifyAll();
                    } else {
                        // 桌子上没有食物, 等待
                        try {
                            Desk_ControlData.lock.wait(); // 将当前线程与锁对象进行绑定, 便于指定唤醒对应线程
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
