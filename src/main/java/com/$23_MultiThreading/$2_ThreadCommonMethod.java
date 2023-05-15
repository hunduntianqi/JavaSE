package com.$23_MultiThreading;

/*
    Thread类的常见方法:
        开始和执行线程:
            void run(): 封装线程执行的代码, 直接调用相当于普通的方法调用, 不会开启子线程
            void start(): 开启子线程, JVM 调用run()方法执行
        设置和获取线程名称
            void setName(String name): 更改指定线程名称
            String getName(): 获取线程名称
            Thread currentThread(): 返回对当前正在执行的线程对象的引用(获取线程对象)
        线程休眠:
            static void sleep(long millis): 使当前正在执行的线程停留(暂停执行)指定的毫秒数
        线程优先级:
            java中多线程的执行为抢占式调度, 具有随机性, 线程的优先级越高, 则抢占CPU的概率越大, 并不代表优先级高的一定可以抢占到CPU
            final int getPriority(): 返回线程的优先级
            final void setPriority(int newPriority): 更改线程的优先级, 默认是5; 线程优先级范围为1~10, 最小是1, 最大是10
        设置守护线程:
            void setDaemon(boolean on): 将线程标记为守护线程, 当运行的线程都是守护线程时, JVM将退出
        出让线程/礼让线程:
            public static void yield(): 表示出让CPU的执行权
        插入线程/插队线程:
            public static void join()

 */
public class $2_ThreadCommonMethod {
    public static void main(String[] args) throws Exception {
        threadNameTest();
        threadSleep();
        threadPriority();
        threadYield();
    }

    // 定义方法测试线程名相关方法
    public static void threadNameTest() {
        // 创建MyThread对象
        MyThread myThread = new MyThread();
        // 开启子线程
        myThread.start();
        // 获取线程名称
        String threadName = myThread.getName();
        System.out.printf("当前子线程名称为 %s%n", threadName);
        // 修改子线程名称
        myThread.setName("混沌天炁");
        System.out.printf("修改后线程名称为 %s%n", myThread.getName());
        // 获取当前正在执行的线程引用
        Thread thread = Thread.currentThread();
        System.out.printf("当前正在执行的线程为: %s%n", thread.getName());
    }

    // 定义方法测试线程休眠方法
    public static void threadSleep() throws Exception {
        System.out.println("================================");
        // 设置主线程休眠3s
        System.out.println("主线程休眠三秒钟");
        Thread.sleep(3000); // 主线程停留三秒后再执行后续代码
        // 创建子线程对象
        MyThread myThread = new MyThread();
        // 开启子线程
        myThread.start();
    }

    // 定义方法测试线程优先级
    public static void threadPriority() {
        System.out.println("============================");
        // 创建MyRunnable对象
        MyRunnable myRunnable = new MyRunnable();
        // 创建Thread对象
        Thread thread1 = new Thread(myRunnable, "炼虚合道");
        Thread thread2 = new Thread(myRunnable, "不朽帝仙");
        // 打印观察两个线程的默认优先级
        System.out.println("线程 " + thread1.getName() + " 默认优先级为: " + thread1.getPriority());
        System.out.println("线程 " + thread2.getName() + " 默认优先级为: " + thread2.getPriority());
        // 打印观察主线程的默认优先级
        System.out.println("线程 " + Thread.currentThread().getName() + " 默认优先级为: " + Thread.currentThread().getPriority());
        // 修改子线程优先级
        thread1.setPriority(1);
        thread2.setPriority(10);
        // 启动子线程
        thread1.start();
        thread2.start();
    }

    // 定义方法测试出让线程/礼让线程
    public static void threadYield() {
        System.out.println("=======================");
        // 创建两个MyThread对象
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        // 修改两个线程对象的名字
        myThread1.setName("炼虚合道");
        myThread2.setName("不朽帝仙");
        // 启动线程
        myThread1.start();
        myThread2.start();
    }
}

// 定义类来继承Thread
class MyThread extends Thread {
    // 重写run()方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.printf("当前正在执行的线程为: %s - %s\n", Thread.currentThread().getName(), i + 1);
            if (i == 50) {
                Thread.yield();
            }
        }
    }
}

// 定义类实现Runnable接口
class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }
    }
}