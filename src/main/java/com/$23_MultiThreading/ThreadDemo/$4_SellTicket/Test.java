package com.$23_MultiThreading.ThreadDemo.$4_SellTicket;

public class Test {
    public static void main(String[] args) {
        // 创建SellTicket对象
        SellTicket sellTicket = new SellTicket();
        // 创建三个Thread对象, 代表三个窗口
        Thread thread1 = new Thread(sellTicket, "窗口1");
        Thread thread2 = new Thread(sellTicket, "窗口2");
        Thread thread3 = new Thread(sellTicket, "窗口3");
        // 启动三个线程
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
