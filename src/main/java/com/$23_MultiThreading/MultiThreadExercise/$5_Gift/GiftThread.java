package com.$23_MultiThreading.MultiThreadExercise.$5_Gift;

import java.util.ArrayList;
import java.util.Collections;

public class GiftThread extends Thread {
    // 定义集合, 代表存放奖金的奖池
    static ArrayList<Integer> list = new ArrayList<>();

    // 静态代码块初始化奖池数据
    static {
        // 集合中存入奖金数据
        Collections.addAll(list, 10, 5, 20, 50, 100, 200, 800, 2, 80, 300, 700);
        // 打乱集合元素
        Collections.shuffle(list);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (GiftThread.class) {
                // 1. 判断奖池是否为空
                if (list.size() == 0) {
                    // 奖池为空, 结束循环
                    break;
                } else {
                    // 奖池不为空, 抽奖
                    System.out.println(Thread.currentThread().getName() + "抽出了" + list.remove(0) + "元大奖");

                }
            }
            // 睡眠
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
