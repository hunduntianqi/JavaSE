package com.$18_Gather.Comprehensive_exercise;

/*
    随机点名器一:
        班级里有N个学生, 实现随机点名器
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class $1_RollCall_One {
    public static void main(String[] args) {
        // 新建集合, 用于存储数据
        ArrayList<String> list = new ArrayList<>();
        // 使用集合工具类Collections, 批量添加数据
        Collections.addAll(list, "范闲", "范建", "范统", "杜子腾", "杜琦燕", "宋合泛",
                "侯龙腾", "朱益群", "朱穆朗玛峰", "袁明媛");
        // 随机点名方法一:
        Random random = new Random();
        int index = random.nextInt(list.size());
        String name = list.get(index);
        System.out.println("随机方法一点到的名字为:" + name);
        // 随机点名方法二:
        Collections.shuffle(list); // 打乱集合顺序
        name = list.get(0);
        System.out.println("随机方法二点到的名字为:" + name);
    }
}
