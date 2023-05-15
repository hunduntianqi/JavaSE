package com.$18_Gather.Demo.$4_MapGatherDemo.$1_HashMapExercise.$1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        // 创建HashMap, 键为Student类型, 值为String类型
        HashMap<Student, String> hashMap = new HashMap<>();
        // 添加数据
        hashMap.put(new Student("郭鹏涛", 24), "河南省洛阳市");
        hashMap.put(new Student("郭鹏强", 22), "河南省洛阳市");
        hashMap.put(new Student("汤前优", 22), "山西省太原市");
        hashMap.put(new Student("郭鹏涛", 24), "混沌天宫"); // Student对象姓名和年龄相同, 认为是同一对象
        // lambda表达式遍历集合
        hashMap.forEach((key, value) -> System.out.println(key + ":" + value));
        System.out.println("============================");
        // 键找值形式遍历集合
        Set<Student> keySet = hashMap.keySet();
        for (Student key : keySet) {
            System.out.println(key + ":" + hashMap.get(key));
        }
        System.out.println("============================");
        // 键值对对象形式遍历集合
        Set<Map.Entry<Student, String>> entrySet = hashMap.entrySet();
        for (Map.Entry<Student, String> entry : entrySet) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
