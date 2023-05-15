package com.$23_MultiThreading;

import java.util.concurrent.*;

/*
    线程池:
        核心原理:
            1. 创建一个池子, 刚开始池子中是空的
            2. 提交任务时, 池子会创建新的线程对象; 任务执行完毕后, 线程归还给池子, 下次再提交任务时, 直接复用已有的线程即可
            3. 如果提交任务时, 池子中没有空闲线程, 并且线程数已达到最大数量, 无法创建新的线程, 任务就会排队等待
        代码实现:
            1. 创建线程池
                Executors: 线程池的工具类, 通过调用方法返回不同类型的线程池对象
                public static ExecutorService newCachedThreadPool(): 创建一个没有上限的线程池(线程数量最大为int的最大值)
                public static ExecutorService newFixedThreadPool(int nThreads): 创建有上限的线程池
            2. 提交任务
                线程池对象.submit(多线程任务对象)
            3. 所有任务执行完毕后, 关闭线程池
                线程池对象.shutdown()
        自定义线程池:
            ThreadPoolExecutor (int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
            BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler): 使用给定参数来创建一个线程池
                参数解析:
                    corePoolSize: 核心线程数 (不能小于零)
                    maximumPoolSize: 最大线程数 (大于或等于核心线程数量)
                    keepAliveTime: 线程空闲时间的数值 (不能小于零)
                    unit: 线程空闲时间的单位(秒, 毫秒等) (用TimeUnit来指定)
                    workQueue: 阻塞队列 (不能为null)
                    threadFactory: 创建线程的方式 (不能为null)
                    handler: 执行任务过多时的解决方式 (不能为null), 以下四个实际为ThreadPoolExecutor的静态内部类
                        1. ThreadPoolExecutor.AbortPolicy(): 默认策略, 丢弃任务并抛出RejectedExecutionException异常
                        2. ThreadPoolExecutor.DiscardPolicy: 丢弃任务, 但是不抛出异常, 不推荐的做法
                        3. ThreadPoolExecutor.DiscardOldestPolicy: 抛弃队列中等待最久的任务, 然后把当前任务加入到队列中
                        4. ThreadPoolExecutor.CallerRunsPolicy: 调用任务的run()方法绕过线程池直接执行
            自定义线程池提交任务注意点:
                1. 当核心线程排满时, 再提交任务就会进入阻塞队列排队
                2. 当核心线程和阻塞队列都排满时, 再提交任务会创建临时线程
                3. 当核心线程, 阻塞队列, 临时线程都排满时, 再提交任务会触发任务拒绝策略
            线程池多大合适:
                计算机最大并行数 ==》任务管理器 ==》性能 ==》 右下角'逻辑处理器数'
                1. CPU密集型运算: 计算较多, 读写文件和数据库操作较少
                    核心线程数为: 最大并行数 + 1 最合适
                2. I/O密集型运算: CPU计算较少, 读取文件和数据库操作较多
                    核心线程数为: 最大并行数 * 期望利用率 * (总时间(CPU计算时间+等待时间) / CPU计算时间)
 */
public class $5_ThreadPool {
    public static void main(String[] args) {
        poolTest();
        poolObject();
    }

    public static void poolTest() {
        /*
            public static ExecutorService newCachedThreadPool(): 创建一个没有上限的线程池(线程数量最大为int的最大值)
            public static ExecutorService newFixedThreadPool(int nThreads): 创建有上限的线程池
         */
        // 1. 创建线程池对象
        ExecutorService pool = Executors.newCachedThreadPool();
        // 2. 提交任务
        pool.submit(new MyRunnablePool());
        // 3. 销毁线程池
        pool.shutdown();
    }

    // 自定义线程池对象
    public static void poolObject() {
        /*
            ThreadPoolExecutor (int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
            BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler): 使用给定参数来创建一个线程池
                参数解析:
                    corePoolSize: 核心线程数 (不能小于零)
                    maximumPoolSize: 最大线程数 (大于或等于核心线程数量)
                    keepAliveTime: 线程空闲时间的数值, 超过规定时间销毁临时线程 (不能小于零)
                    unit: 线程空闲时间的单位(秒, 毫秒等) (用TimeUnit来指定)
                    workQueue: 阻塞队列 (不能为null)
                    threadFactory: 创建线程的方式 (不能为null)
                    handler: 执行任务过多时的解决方式 (不能为null)
                        1. ThreadPoolExecutor.AbortPolicy: 默认策略, 丢弃任务并抛出RejectedExecutionException异常
                        2. ThreadPoolExecutor.DiscardPolicy: 丢弃任务, 但是不抛出异常, 不推荐的做法
                        3. ThreadPoolExecutor.DiscardOldestPolicy: 抛弃队列中等待最久的任务, 然后把当前任务加入到队列中
                        4. ThreadPoolExecutor.CallerRunsPolicy: 调用任务的run()方法绕过线程池直接执行
         */
        // 创建线程池对象
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3, // 核心线程数量, 不能小于0
                6, // 最大线程数量, 不能小于0, 并且要大于或等于核心线程数量
                60, // 空闲时间值, 超过规定时间销毁临时线程
                TimeUnit.SECONDS, // 空闲时间单位为秒
                new ArrayBlockingQueue<>(3), // 创建任务阻塞队列
                Executors.defaultThreadFactory(), // 创建线程的方式
                new ThreadPoolExecutor.AbortPolicy() // 任务拒绝策略
        );
        // 提交任务
        pool.submit(new MyRunnablePool());
        // 销毁线程池
        pool.shutdown();
    }
}

// 定义测试类, 用于测试线程池
class MyRunnablePool implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }
    }
}
