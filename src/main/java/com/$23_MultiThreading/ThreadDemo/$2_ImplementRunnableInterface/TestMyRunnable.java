package com.$23_MultiThreading.ThreadDemo.$2_ImplementRunnableInterface;

public class TestMyRunnable {
    public static void main(String[] args) {
        // 创建MyRunnable对象
        MyRunnable myRunnable = new MyRunnable();
        // 创建Thread对象
        Thread thread = new Thread(myRunnable, "子线程");
        // 启动子线程
        thread.start();
    }
}
