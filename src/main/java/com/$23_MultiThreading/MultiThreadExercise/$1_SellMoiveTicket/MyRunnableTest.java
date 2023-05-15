package com.$23_MultiThreading.MultiThreadExercise.$1_SellMoiveTicket;

public class MyRunnableTest {
    /*
       需求:
           卖电影票, 一共有一千张电影票, 可以在两个窗口领取, 每次领取的时间是3000毫秒
    */
    public static void main(String[] args) {
        // 创建MyRunnable对象
        MyRunnable myRunnable = new MyRunnable();
        // 创建两个Thread对象, 代表两个窗口
        Thread thread1 = new Thread(myRunnable, "窗口1");
        Thread thread2 = new Thread(myRunnable, "窗口2");
        // 启动线程
        thread1.start();
        thread2.start();
    }
}
