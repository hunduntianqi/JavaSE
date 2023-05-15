package com.$23_MultiThreading.ThreadDemo.$8_BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockQueueTest {
    // 通过阻塞队列来实现等待唤醒机制
    // 细节: 生产者和消费者必须使用同一个阻塞队列
    public static void main(String[] args) {
        // 创建阻塞队列, 作为生产者消费者共同使用
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(1);
        // 创建生产者对象
        Cook_BlockQueue cook = new Cook_BlockQueue(queue, 0);
        // 创建消费者对象
        Foodie_BlockQueue foodie = new Foodie_BlockQueue(queue, 0);
        foodie.setName("吃货");
        // 启动子线程
        cook.start();
        foodie.start();
    }
}
