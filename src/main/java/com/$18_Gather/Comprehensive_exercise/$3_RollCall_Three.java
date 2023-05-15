package com.$18_Gather.Comprehensive_exercise;

/*
    自动点名器三:
        班级里有N个学生, 要求被点到的学生不会再被点到, 但是如果班级里所有的学生都点完了,
        需要重新开启第二轮点名
        思路一: 使用Set集合实现
        思路二: 将每次随机点到的学生姓名从集合中删除, 当集合长度为0时, 重新将所有学生姓名存储集合
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class $3_RollCall_Three {
    public static void main(String[] args) {
        // 定义集合, 存储所有学生的姓名
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "范闲", "范建", "范统", "杜子腾", "杜琦燕", "宋合泛",
                "侯龙腾", "朱益群", "朱穆朗玛峰", "袁明媛");
        // 思路一: 创建Set集合存储被点到的学生姓名
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            System.out.printf("开始第%s轮点名!!\n".formatted(i + 1));
            while (set.size() != list.size()) {
                // 打乱集合list
                Collections.shuffle(list);
                boolean flag = set.add(list.get(0));
                if (flag) {
                    System.out.println("被点到名的学生为: " + list.get(0));
                }
            }
            set.clear();
        }

        // 思路二: 通过删除集合元素实现不重复点名
        for (int i = 0; i < 3; i++) {
            System.out.printf("开始第%s轮点名!!\n".formatted(i + 1));
            while (list.size() != 0) {
                // 打乱集合list
                Collections.shuffle(list);
                // 获取集合第一个元素值并删除集合第一个元素
                String name = list.remove(0);
                System.out.println("被点到名的学生为: " + name);
            }
            // 一轮点名结束, 重新开始点名, 将学生姓名存入集合
            Collections.addAll(list, "范闲", "范建", "范统", "杜子腾", "杜琦燕", "宋合泛",
                    "侯龙腾", "朱益群", "朱穆朗玛峰", "袁明媛");
        }

    }
}
