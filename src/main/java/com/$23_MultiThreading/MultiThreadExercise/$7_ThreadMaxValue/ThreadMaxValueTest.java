package com.$23_MultiThreading.MultiThreadExercise.$7_ThreadMaxValue;

import java.util.concurrent.FutureTask;

public class ThreadMaxValueTest {
    /*
    有一个抽奖池, 该奖池中存放了奖励的金额, 该抽奖池中的奖项为:
    {10, 5, 20, 50, 100, 200, 800, 2, 80, 300, 700};
    要求:
        创建两个抽奖箱, 设置线程名为'抽奖箱1', '抽奖箱2', 每次抽奖时不打印, 抽完奖后一次性打印(随机)
        在此次抽奖过程中, 抽奖箱1总共产生了xx个奖项, 最高奖项为xx元, 总额为xx元
        在此次抽奖过程中, 抽奖箱2总共产生了xx个奖项, 最高奖项为xx元, 总额为xx元
        在此次抽奖中, 抽奖箱x产生了最大奖项, 奖金为xxx元
            核心逻辑 ==> 获取两个线程运行后的结果
    */
    public static void main(String[] args) throws Exception {
        // 创建Callable对象
        ThreadMaxValueCall call = new ThreadMaxValueCall();
        // 创建两个FutureTask对象
        FutureTask<Integer> task1 = new FutureTask<>(call);
        FutureTask<Integer> task2 = new FutureTask<>(call);
        // 创建两个Thread对象
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        // 修改线程名称
        thread1.setName("抽奖箱1");
        thread2.setName("抽奖箱2");
        // 启动线程
        thread1.start();
        thread2.start();
        // 判断最大金额
        if (task1.get() > task2.get()) {
            System.out.println("此次抽奖中, " + thread1.getName() + "产生了最大金额, 最大金额为: " + task1.get() + "元");
        } else {
            System.out.println("此次抽奖中, " + thread2.getName() + "产生了最大金额, 最大金额为: " + task2.get() + "元");
        }
    }
}
