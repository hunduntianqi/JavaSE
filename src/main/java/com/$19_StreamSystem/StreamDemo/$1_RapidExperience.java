package com.$19_StreamSystem.StreamDemo;

import java.util.ArrayList;
import java.util.Collections;

public class $1_RapidExperience {
    // Stream快速体验
    public static void main(String[] args) {
        // 创建List集合
        ArrayList<String> list = new ArrayList<>();
        // 使用集合工具类添加数据
        Collections.addAll(list, "张三丰", "张无忌", "周芷若", "赵敏", "张强");
        // 使用Stream流筛选出姓氏为张, 并且名字是三个字的元素
        list.stream().filter(name -> name.startsWith("张")).filter(name -> name.length() == 3).forEach(name -> System.out.println(name));
    }
}
