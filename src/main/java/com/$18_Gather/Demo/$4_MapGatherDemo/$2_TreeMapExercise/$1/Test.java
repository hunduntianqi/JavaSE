package com.$18_Gather.Demo.$4_MapGatherDemo.$2_TreeMapExercise.$1;

import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        // 创建TreeMap集合, 并指定根据键名进行升序排列
        TreeMap<Integer, String> treeMap = new TreeMap<>((o1, o2) -> o1 - o2);
        // 集合添加数据
        treeMap.put(1, "电脑");
        treeMap.put(4, "显示器");
        treeMap.put(3, "键盘");
        treeMap.put(2, "鼠标");
        System.out.println(treeMap);
        
        // 创建TreeMap集合, 并根据键名进行降序排列
        TreeMap<Integer, String> treeMap1 = new TreeMap<>((o1, o2)-> o2 - o1);
        // 集合添加数据
        treeMap1.put(1, "电脑");
        treeMap1.put(4, "显示器");
        treeMap1.put(3, "键盘");
        treeMap1.put(2, "鼠标");
        System.out.println(treeMap1);
    }
}
