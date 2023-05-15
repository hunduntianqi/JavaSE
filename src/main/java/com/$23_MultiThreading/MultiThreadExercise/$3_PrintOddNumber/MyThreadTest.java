package com.$23_MultiThreading.MultiThreadExercise.$3_PrintOddNumber;

public class MyThreadTest {
    // 需求: 打印奇数数字, 输出0-100之间所有的奇数数字
    public static void main(String[] args) {
        // 创建两个线程对象
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        // 修改线程名
        myThread1.setName("线程1");
        myThread2.setName("线程2");
        // 启动线程
        myThread1.start();
        myThread2.start();
    }
}
