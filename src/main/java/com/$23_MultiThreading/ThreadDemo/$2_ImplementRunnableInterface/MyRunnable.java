package com.$23_MultiThreading.ThreadDemo.$2_ImplementRunnableInterface;

// 定义MyRunnable类实现Runnable接口
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        // 重写接口run()方法
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            System.out.println("%s : %s".formatted(Thread.currentThread().getName(), i + 1));
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时 %s s".formatted((end - start) / 1000.0));
    }
}
