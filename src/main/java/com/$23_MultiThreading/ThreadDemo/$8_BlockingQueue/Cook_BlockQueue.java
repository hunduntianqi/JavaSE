package com.$23_MultiThreading.ThreadDemo.$8_BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

// 定义生产者类, 继承Thread类
public class Cook_BlockQueue extends Thread {
    // 定义成员变量队列
    ArrayBlockingQueue<String> queue;
    // 定义变量记录厨师做了多少碗面条
    private int count = 0;

    // 定义无参构造
    public Cook_BlockQueue() {
    }

    // 定义有参构造
    public Cook_BlockQueue(ArrayBlockingQueue<String> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    @Override
    public void run() {
        while (true) {
            if (this.count < 10) {
                try {
                    this.queue.put("面条");
                    System.out.println("厨师放了一碗面条到队列中");
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
