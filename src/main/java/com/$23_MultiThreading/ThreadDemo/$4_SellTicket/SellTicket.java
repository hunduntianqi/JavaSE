package com.$23_MultiThreading.ThreadDemo.$4_SellTicket;

/*
    - 案例需求
        某电影院目前正在上映国产大片，共有100张票，而它有3个窗口卖票，请设计一个程序模拟该电影院卖票
    - 实现步骤
        - 定义一个类SellTicket实现Runnable接口，里面定义一个成员变量：private int tickets = 100;
        - 在SellTicket类中重写run()方法实现卖票，代码步骤如下
        - 判断票数大于0，就卖票，并告知是哪个窗口卖的
        - 卖了票之后，总票数要减1
        - 票卖没了，线程停止
        - 定义一个测试类SellTicketDemo，里面有main方法，代码步骤如下
        - 创建SellTicket类的对象
        - 创建三个Thread类的对象，把SellTicket对象作为构造方法的参数，并给出对应的窗口名称
        - 启动线程
 */
public class SellTicket implements Runnable {
    // 定义变量, 记录剩余票数, static 修饰代表是类的属性, 类的所有对象共享
    private static int tickets = 100;

    // 创建一个任意对象, 作为锁对象, 锁对象必须是唯一的
    // static Object object = new SellTicket();
    @Override
    public void run() {
        // 实现卖票逻辑
        while (true) {
            synchronized (SellTicket.class) {
                if (tickets > 0) {
                    SellTicket.tickets--;
                    System.out.printf("%s 售出一张票, 剩余票数为: %s%n", Thread.currentThread().getName(), SellTicket.tickets);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}
