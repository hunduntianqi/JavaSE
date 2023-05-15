package com.$23_MultiThreading.MultiThreadExercise.$6_MaxValue;

import java.util.ArrayList;
import java.util.Collections;

public class MaxValueThread extends Thread {
    // 定义静态集合, 代表存放奖金的奖池
    static ArrayList<Integer> list = new ArrayList<>();

    // 静态代码块初始化奖池数据
    static {
        // 集合中存入奖金数据
        Collections.addAll(list, 10, 5, 20, 50, 100, 200, 800, 2, 80, 300, 700);
        // 打乱集合元素
        Collections.shuffle(list);
    }

    // 定义非静态集合, 用来存放此抽奖箱抽到的数据
    ArrayList<Integer> this_list = new ArrayList<>();

    // 创建带参数构造器
    public MaxValueThread(ArrayList<Integer> this_list) {
        this.this_list = this_list;
    }

    // 创建无参构造
    public MaxValueThread() {
    }

    // 重写run方法
    @Override
    public void run() {
        while (true) {
            synchronized (MaxValueThread.class) {
                // 1. 判断奖池是否为空
                if (list.size() == 0) {
                    // 奖池为空, 结束循环
                    break;
                } else {
                    // 奖池不为空, 抽奖
                    int gift = list.remove(0);
//                    System.out.println(Thread.currentThread().getName() + "抽出了" + gift + "元大奖");
                    // 将抽到的奖金存入集合
                    this.this_list.add(gift);
                }
            }
            // 睡眠
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 循环结束代表奖池已为空, 抽奖完成
        System.out.printf("在此次抽奖过程中, %s总共产生了%s个奖项, 详情如下: \n %s, 最高奖项为%s元, 总额为%s元\n", Thread.currentThread().getName(),
                this.this_list.size(), this.this_list ,Collections.max(this.this_list), sum(this.this_list));
//        System.out.println(Thread.currentThread().getName() + "奖池抽奖结果为: \n" + this.this_list);
//        System.out.println(Thread.currentThread().getName() + "奖池总额为: " + sum(this.this_list) + "元");
//        System.out.println(Thread.currentThread().getName() + "奖池最大值为: " + Collections.max(this.this_list));
    }
    // 定义方法计算奖池总额
    public int sum (ArrayList<Integer> list) {
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        return sum;
    }
}
