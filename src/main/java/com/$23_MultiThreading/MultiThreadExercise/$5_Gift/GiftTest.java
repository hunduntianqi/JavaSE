package com.$23_MultiThreading.MultiThreadExercise.$5_Gift;

public class GiftTest {
    /*
        抽奖箱抽奖:
            有一个抽奖池, 该奖池中存放了奖励的金额, 该抽奖池中的奖项为:
            {10, 5, 20, 50, 100, 200, 800, 2, 80, 300, 700};
            要求:
                创建两个抽奖箱, 设置线程名为'抽奖箱1', '抽奖箱2', 随机从抽奖池中获取奖项元素并打印在控制台上, 格式如下:
                    每次抽取一个奖项就打印一个(随机)
                    抽奖箱1 产生了一个xx元大奖
                    抽奖箱2 产生了一个xx元大奖
                    抽奖箱2 产生了一个xx元大奖
                    抽奖箱1 产生了一个xx元大奖
                    ...
     */
    public static void main(String[] args) {
        // 创建两个线程对象
        GiftThread thread1 = new GiftThread();
        GiftThread thread2 = new GiftThread();
        // 修改线程名称
        thread1.setName("抽奖箱1");
        thread2.setName("抽奖箱2");
        // 启动线程
        thread1.start();
        thread2.start();
    }
}
