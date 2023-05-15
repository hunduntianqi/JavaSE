package com.$18_Gather.Demo.$4_MapGatherDemo.$2_TreeMapExercise.$2;

import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        // 创建TreeMap集合
        TreeMap<Student, String> treeMap = new TreeMap<>();
        // 集合添加数据
        treeMap.put(new Student("郭鹏涛", 24), "河南省洛阳市");
        treeMap.put(new Student("郭鹏强", 21), "河南省洛阳市");
        treeMap.put(new Student("汤前优", 22), "河南省洛阳市");
        treeMap.put(new Student("王传泽", 24), "河南省商丘市");
        treeMap.put(new Student("郭鹏涛", 24), "混沌天宫");
        System.out.println(treeMap);
    }
}
