package com.$23_MultiThreading.MultiThreadExercise.$2_GiveGift;


public class MyRunnableTest {
    /*
        需求:
            赠送礼物, 有100分礼品, 两人同时发送, 剩下的礼品小于10份时则不再送出
     */
    public static void main(String[] args) {
        // 创建MyRunnable对象
        MyRunnable myRunnable = new MyRunnable();
        // 创建两个Thread对象, 代表两个窗口
        Thread thread1 = new Thread(myRunnable, "服务员1");
        Thread thread2 = new Thread(myRunnable, "服务员2");
        // 启动线程
        thread1.start();
        thread2.start();
    }
}
