package com.$23_MultiThreading.ThreadDemo.$8_BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

// 定义消费者类, 继承Thread类
public class Foodie_BlockQueue extends Thread {
    // 定义成员变量队列
    public ArrayBlockingQueue<String> queue;
    // 定义变量记录吃货吃了多少面条
    private int count = 0;

    // 定义无参构造
    public Foodie_BlockQueue() {
    }

    // 定义有参构造
    public Foodie_BlockQueue(ArrayBlockingQueue<String> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    @Override
    public void run() {
        while (true) {
            if (this.count < 10) {
                try {
                    System.out.printf("%s 吃了一碗 %s\n", Thread.currentThread().getName(), this.queue.take());
                    this.count++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                break;
            }
        }
    }
}
