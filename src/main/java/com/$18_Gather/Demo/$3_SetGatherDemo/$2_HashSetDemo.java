package com.$18_Gather.Demo.$3_SetGatherDemo;

import java.util.HashSet;

public class $2_HashSetDemo {
    /*
        创建一个存储学生对象的集合, 存储多个学生对象, 要求学生对象的成员变量值相同, 就认为是同一个对象
     */
    public static void main(String[] args) {
        // 创建HashSet集合
        HashSet<$2_Student> listSet = new HashSet<>();
        listSet.add(new $2_Student("斗破苍穹", 11));
        listSet.add(new $2_Student("斗破苍穹", 11)); // 属性值一致认为是重复数据, 添加失败
        listSet.add(new $2_Student("武动乾坤", 10));
        listSet.add(new $2_Student("大主宰", 6));
        listSet.add(new $2_Student("遮天", 11));
        listSet.add(new $2_Student("完美世界", 6));
        listSet.add(new $2_Student("龙血战神", 6));
        
        // 遍历集合
        for ($2_Student student : listSet) {
            System.out.println(student);
        }
    }
}
