package com.$23_MultiThreading.MultiThreadExercise.$6_MaxValue;

public class MaxValueTest2 {
    /*
        有一个抽奖池, 该奖池中存放了奖励的金额, 该抽奖池中的奖项为:
        {10, 5, 20, 50, 100, 200, 800, 2, 80, 300, 700};
        要求:
            创建两个抽奖箱, 设置线程名为'抽奖箱1', '抽奖箱2', 每次抽奖时不打印, 抽完奖后一次性打印(随机)
            在此次抽奖过程中, 抽奖箱1总共产生了xx个奖项, 最高奖项为xx元, 总额为xx元
            在此次抽奖过程中, 抽奖箱2总共产生了xx个奖项, 最高奖项为xx元, 总额为xx元
     */
    public static void main(String[] args) {
        // 创建两个线程对象
        MaxValueThread2 thread1 = new MaxValueThread2();
        MaxValueThread2 thread2 = new MaxValueThread2();
        // 修改线程名称
        thread1.setName("抽奖箱 1");
        thread2.setName("抽奖箱 2");
        // 启动线程
        thread1.start();
        thread2.start();
    }
}
