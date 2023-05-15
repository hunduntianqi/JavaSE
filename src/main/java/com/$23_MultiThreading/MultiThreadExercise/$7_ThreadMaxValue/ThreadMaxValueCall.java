package com.$23_MultiThreading.MultiThreadExercise.$7_ThreadMaxValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;

public class ThreadMaxValueCall implements Callable<Integer> {
    // 定义静态集合, 存放奖金数据
    static ArrayList<Integer> list = new ArrayList<>();
    // 静态代码块初始化奖池数据
    static {
        // 集合中存入奖金数据
        Collections.addAll(list, 10, 5, 20, 50, 100, 200, 800, 2, 80, 300, 700);
        // 打乱集合元素
        Collections.shuffle(list);
    }

    // 重写call方法
    @Override
    public Integer call() throws Exception {
        // 创建集合, 存放每个抽奖箱各自抽到的奖金数据
        ArrayList<Integer> this_list = new ArrayList<>();
        // 循环抽奖
        while (true) {
            // 静态代码块
            synchronized (ThreadMaxValueCall.class) {
                // 判断奖池是否为空
                if (list.size() == 0) {
                    // 奖池为空, 循环结束, 打印抽奖信息
                    System.out.printf("在此次抽奖过程中, %s总共产生了%s个奖项, 详情如下: \n %s, 最高奖项为%s元, 总额为%s元\n", Thread.currentThread().getName(),
                            this_list.size(), this_list ,Collections.max(this_list), sum(this_list));
                    break;
                } else {
                    // 奖池不为空, 开始抽奖
                    int gift = list.remove(0);
                    // System.out.println(Thread.currentThread().getName() + "抽出了" + gift + "元大奖");
                    // 将抽到的奖金存入集合
                    this_list.add(gift);
                }
            }
            Thread.sleep(10);
        }
        // 返回该次抽奖对应抽奖箱的最大奖金
        // 判断当前线程是否未抽到奖
        if (this_list.size() == 0) {
            return null;
        } else {
            return Collections.max(this_list);
        }
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
