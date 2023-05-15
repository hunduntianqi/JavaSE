package com.$18_Gather.Demo.$4_MapGatherDemo.$1_HashMapExercise.$2;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        // 创建HashMap集合
        HashMap<String, Integer> hashMap = new HashMap();
        // 定义数组, 存放四个景点
        String[] scenicSpot = {"A", "B", "C", "D"};
        // 创建Random对象, 产生随机数
        Random random = new Random();
        for (int i = 0; i < 80; i++) {
            // 随机获取景点
            String spot = scenicSpot[random.nextInt(4)];
            // 判断景点是否存在集合中
            if (hashMap.containsKey(spot)) {
                // 景点存在集合中, 景点对应的数值加一
                hashMap.put(spot, hashMap.get(spot) + 1);
            } else {
                // 景点不存在集合中, 将景点添加入集合, 并设置值为一
                hashMap.put(spot, 1);
            }
        }
        // lambda表达式遍历hashMap
        hashMap.forEach((key, value) -> System.out.println(key + ":" + value));
        System.out.println("===================");
        // 键值对遍历HashMap
        Set<Map.Entry<String, Integer>> entrySet = hashMap.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("===================");
        // 键找值形式遍历集合
        Set<String> setKey = hashMap.keySet();
        for (String key : setKey) {
            System.out.println(key + ":" + hashMap.get(key));
        }
    }
}
