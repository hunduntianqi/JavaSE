package com.$23_MultiThreading.ThreadDemo.$5_SyncMethod;

public class MyRunnable implements Runnable {
    // 定义静态变量记录卖出票数
    private int ticket = 0;

    @Override
    public void run() {
        while (true) {
            if (!ticketMethod()) {
                break;
            }
        }
    }

    // 定义非静态同步方法
    public synchronized boolean ticketMethod () {
        if (ticket < 1000) {
            ticket++;
            System.out.printf("%s 卖出了第 %s 张票\n", Thread.currentThread().getName(), ticket);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            return false;
        }
        return true;
    }
}
