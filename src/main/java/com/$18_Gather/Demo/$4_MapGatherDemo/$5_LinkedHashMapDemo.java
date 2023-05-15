package com.$18_Gather.Demo.$4_MapGatherDemo;

import java.util.LinkedHashMap;

/*
    是HashMap的子类
    特点: 由键决定, 有序, 不重复, 无索引
    底层是哈希表结构, 每个键值对元素又额外多出一个双链表的机制记录存储的顺序
 */
public class $5_LinkedHashMapDemo {
    public static void main(String[] args) {
        // 创建集合
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        // 添加元素
        linkedHashMap.put("龙血战神", "龙辰");
        linkedHashMap.put("吞天记", "吴煜");
        linkedHashMap.put("遮天", "叶凡");
        linkedHashMap.put("完美世界", "石昊");
        linkedHashMap.put("圣龙图腾", "姜自在");
        linkedHashMap.put("万古第一神", "李天命");
        // 遍历集合, LinkedHashMap存取顺序一致
        linkedHashMap.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}
