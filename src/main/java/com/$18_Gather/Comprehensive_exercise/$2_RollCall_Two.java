package com.$18_Gather.Comprehensive_exercise;

/*
    随机点名器二:
        班级里有N个学生, 要求70%概率随机到男生, 30%概率随机到女生
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class $2_RollCall_Two {
    public static void main(String[] args) {
        // 创建集合
        ArrayList<Integer> list = new ArrayList<>();
        // 向集合中添加7个1, 3个0
        Collections.addAll(list, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0);
        // 打乱集合中的数据
        Collections.shuffle(list);
        System.out.println(list);
        // 从list集合中随机抽取数据
        Random random = new Random();
        int number = list.get(random.nextInt(list.size()));
        System.out.println(number);
        // 分别创建集合存储男生和女生姓名
        ArrayList<String> boyList = new ArrayList<>();
        ArrayList<String> girlList = new ArrayList<>();
        // 向集合写入数据
        Collections.addAll(boyList, "范闲", "范建", "范统", "杜子腾", "宋合泛",
                "侯龙腾", "朱益群", "朱穆朗玛峰");
        Collections.addAll(girlList,"杜琦燕", "袁明媛");
        if (number == 1) {
            // 从男生集合中随机点名
            Collections.shuffle(boyList);
            System.out.println("随机点到的男生是: " + boyList.get(0));
        } else {
            // 从女生集合中随机点名
            Collections.shuffle(girlList);
            System.out.println("随机点到的女生是: " + girlList.get(0));
        }
    }
}
