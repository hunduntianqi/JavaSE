package com.$23_MultiThreading;

/*
    并发和并行:
        并发: 在同一时刻, 有多个指令在单个CPU上交替执行
        并行: 在同一时刻, 有多个指令在多个CPU上同时执行
    进程和线程:
        进程: 是正在运行的程序
            独立性: 进程是一个能独立运行的基本单位, 同时也是系统分配资源和调度的独立单位
            动态性: 进程的实质是程序的一次执行过程, 进程是动态产生, 动态消亡的
            并发性: 任何进程都可以同其他进程一起并发执行
        线程: 是进程中的单个顺序控制流, 是一条执行路径, 是操作系统可以进行运算调度的最小单位
            单线程: 一个进程如果只有一条执行路径, 则称为单线程程序
            多线程: 一个进程如果有多条执行路径, 则称为多线程程序
    多线程实现方式:
        方式一: 继承Thread类:
            实现步骤:
                a. 定义一个MyThread类继承Thread类
                b. 重写run()方法, 封装被线程执行的代码
                c. 创建MyThread类的对象
                d. 启动子线程
            void run(): 在线程开启后, 此方法被调用执行, 封装线程执行的代码;
                        直接调用, 相当于普通方法的调用, 不会开启子线程, 还是在主线程中执行的
            void start(): 使子线程开始执行, JVM会调用run方法, 此时run()方法是在新的线程中执行
        方式二: 实现Runnable接口
            实现步骤:
                a. 定义一个MyRunnable类实现Runnable接口
                b. 在MyRunnable类中重写run()方法
                c. 创建MyRunnable类的对象
                d. 创建Thread类的对象, MyRunnable对象作为构造方法参数传入
                e. 启动子线程
            Thread类相关构造器:
                1. Thread(Runnable target): 根据Runnable创建一个Thread对象
                2. Thread(Runnable target, String name): 根据Runnable创建一个Thread对象, 并指定线程名称
        方式三: 实现Callable接口
            实现步骤:
                a. 定义一个MyCallable类实现Callable接口
                b. 在MyCallable类中重写call()方法
                c. 创建MyCallable类的对象
                d. 创建Future的实现类FutureTask类的对象, MyCallable对象作为构造方法参数传入
                e. 创建Thread类的对象, FutureTask对象作为构造方法参数传入
                f. 启动子线程
                g. 调用get()方法, 获取子线程结束后返回的结果
            相关方法:
                1. V call(): 计算结果, 如果无法计算结果, 则抛出一个异常
                2. FutureTask(Callable<V> callable): 创建一个FutureTask对象, 运行时执行给定的Callable对象
                3. V get(): 等待子线程执行结束, 并获取返回的结果
        三种实现方式对比:
            1. 实现Runnable、Callable接口:
                优点: 扩展性强, 实现接口的同时还可以继承其他的类
                缺点: 编程相对复杂, 不能直接使用Thread类中的方法
            2. 继承Thread类:
                优点: 编程简单, 可以直接使用Thread类中的方法
                缺点: 扩展性较差, 不可以再继承其他的类
 */
public class $1_MultiThreadingSummarize {
}
