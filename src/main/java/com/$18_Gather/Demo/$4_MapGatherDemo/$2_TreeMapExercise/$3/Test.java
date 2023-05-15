package com.$18_Gather.Demo.$4_MapGatherDemo.$2_TreeMapExercise.$3;

import java.util.Scanner;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        // 创建TreeMap集合
        TreeMap<Character, Integer> treeMap = new TreeMap<>((o1, o2) -> o1 - o2);
        // 创建Scanner对象, 接收键盘录入数据
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一段英文字符:");
        String str = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if (treeMap.containsKey(ch)) {
                treeMap.put(ch, treeMap.get(ch) + 1);
            } else {
                treeMap.put(ch, 1);
            }
        }
        System.out.println(treeMap);
    }
}
